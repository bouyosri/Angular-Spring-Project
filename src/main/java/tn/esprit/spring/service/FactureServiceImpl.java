package tn.esprit.spring.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.DetailFactureRepository;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.ProduitRepository;



@Service
public class FactureServiceImpl implements FactureService{
	
	@Autowired
	FactureRepository Facturerepo;
	@Autowired
	ClientRepository Clientrepo;
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	ClientServiceImpl clientserv;
	@Autowired
	DetailFactureRepository DetailFacture;
	

	@Override
	public List<Facture> retrieveAllFactures() {
        return (List<Facture>) this.Facturerepo.findAll();
	}

	@Override
	public void cancelFacture(Long id) {
		Facture Facture = Facturerepo.findById(id).orElse(null);
		Facture.setActive(false);
		Facturerepo.save(Facture);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		return this.Facturerepo.findById(id).orElse(null);
	}
	
	@Scheduled(cron = "0 0 0 1 * *" )
	public void calculRevenu() {
		List<Facture> factures = this.retrieveAllFactures();
		int chiffre = 0;
		for (Object facture2 : factures) {
			Facture facture = (Facture) facture2;
			
			chiffre+=facture.getMontantFacture();
			System.out.println(chiffre);
		}
	}
	
	@Override
	public List<Facture> getFacturesByClient(Long idClient){
		List<Facture> Liste = retrieveAllFactures();
		List<Facture> ListeC = null;
		for (Object element : Liste) {
			Facture facture = (Facture) element;
			if(facture.getClient().getIdClient()==idClient) {
				ListeC.add(facture);
			}
		}
		return ListeC;
	}
	
	
	@Transactional
	@Override
	public Facture addFacture(Facture f, Long idClient) {
		System.out.print("iddddd="+idClient);
	    Date date = new Date();  
		f.setDateFacture(date);
		Client c =clientserv.retrieveClient(idClient);
		f.setClient(c);
		f.setActive(true);
		Facturerepo.save(f);
		float total=0;
		float totalNoRemise=0;
		Set<DetailFacture> DetailFactures=f.getDetailFactures();
		if (DetailFactures!=null) {
			for (Object detailFacture2 : DetailFactures) {
				DetailFacture detailFacture = (DetailFacture) detailFacture2;
				int qte =detailFacture.getQte();
				float prix = detailFacture.getProduit().getPrixUnitaire();
				float montant = qte*prix;
				float montantRemise = (montant*detailFacture.getPourcentageRemise())/100;
				float prixFinal = montant - montantRemise;
				detailFacture.setPrixTotal(prixFinal);
				detailFacture.setMontantRemise(montantRemise);
				totalNoRemise+=montant;
				total+=prixFinal;
				detailFacture.setFacture(f);
				DetailFacture.save(detailFacture);
				
				
			}
			DetailFacture.saveAll(DetailFactures);
			
		}
		
		
		f.setMontantFacture(total);
		float Remise=totalNoRemise-total;
		f.setMontantRemise(Remise);
		Facturerepo.save(f);
		
		return f;
		
	}

	@Override
	public Facture addDetailsFacture(Facture f, Set<DetailFacture> detailsFacture) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void RemoveFacture(Long id) {
		// TODO Auto-generated method stub
		Facturerepo.deleteById(id);
		
	}

}
