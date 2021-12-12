package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.CategorieClient;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.DetailFactureRepository;
import tn.esprit.spring.repository.DetailProduitRepository;
import tn.esprit.spring.repository.FactureRepository;
 


@Service
public class FactureServiceImpl implements FactureService{
	
	@Autowired
	FactureRepository Facturerepo;
	@Autowired
	ClientServiceImpl CLI;
	@Autowired
	ProduitServiceImpl PRI;
@Autowired
DetailFactureRepository DFR;
	@Override
	public List<Facture> retrieveAllFactures() {
        return (List<Facture>) this.Facturerepo.findAll();
	}

	@Override
	public void cancelFacture(Long id) {
		Facture Facture = Facturerepo.findById(id).orElse(null);
		Facture.setActive(false);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		return this.Facturerepo.findById(id).orElse(null);
	}
	
	@Scheduled(cron = "*/9 * * * * *" )
	public void calculRevenu() {
		List<Facture> factures = this.retrieveAllFactures();
		int chiffre = 0;
		for (Object facture2 : factures) {
			Facture facture = (Facture) facture2;
			
			chiffre+=facture.getMontantFacture();
			System.out.println(chiffre);
		}
	}
	@Transactional
	public Facture addFacture(Facture f, Long idClient) {
		Client client = CLI.retrieveClient(idClient);
		f.setClient(client);
		
		float montantTotalFacture=0f;
		float montantRemiseFacture=0f;
		for (DetailFacture detailFact : f.getDetailFactures()) {
			float montantDetail=0f;
			float montantRemiseDetail=0f;
			montantDetail=detailFact.getProduit().getPrixUnitaire()*detailFact.getQte();
			montantRemiseDetail = montantDetail*detailFact.getPourcentageRemise()/100;
			detailFact.setPrixTotal(montantDetail);
			detailFact.setMontantRemise(montantRemiseDetail);
			
			montantTotalFacture+=montantDetail;
			montantRemiseFacture+=montantRemiseDetail;
		}
		
		f.setMontantFacture(montantRemiseFacture);
		f.setMontantRemise(montantRemiseFacture);
		
		return Facturerepo.save(f);
	}

	@Override
	public List<Facture> retrieveFacturesByDates(Date date1, Date date2) {
		return Facturerepo.retrieveFacturesByDates(date1, date2);	}

	@Override
	public List<Facture> getFacturesByClient(Long idClient) {
		return Facturerepo.getFacturesByClient(idClient);
	}

	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
		return Facturerepo.getChiffreAffaireParCategorieClient(categorieClient, startDate, endDate);
		
	}

	@Override
	public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
		float res=0f;

		List<Facture> facts = this.retrieveFacturesByDates(startDate, endDate);
		Set<DetailFacture> detailFactures = null;
		for (Facture facture : facts) {
			detailFactures.addAll(DFR.getDetFactByFactureProduit(facture.getIdFacture(), idProduit));
		}
		Produit produit =PRI.retrieveProduit(idProduit) ;
		for (DetailFacture detailFacture : detailFactures) {
			res+= detailFacture.getQte()*produit.getPrixUnitaire();
		}
		return res;
		
	}


}
