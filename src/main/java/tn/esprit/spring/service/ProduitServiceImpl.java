package tn.esprit.spring.service;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.RayonRepository;
import tn.esprit.spring.repository.StockRepository;


@Service
public class ProduitServiceImpl implements ProduitService
{
	@Autowired
	ProduitRepository Produitrepo;
	FournisseurRepository FourRepo;
	RayonServiceImpl Rayonrepo;
	StockRepository Stockrepo;
	public List<Produit> retrieveAllProduits() {
		return (List<Produit>) Produitrepo.findAll();
	}
	
	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		//Rayon r = Rayonrepo.retrieveRayon(idRayon);
		//Stock s = Stockrepo.findById(idStock).orElse(null);
		//p.setRayon(r);
		//p.setStock(s);
		
		return this.Produitrepo.save(p);
		
	}

	@Override
	public Produit retrieveProduit(Long id) {
		return this.Produitrepo.findById(id).orElse(null);
	}
	
	@Override
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		Fournisseur f = FourRepo.findById(fournisseurId).orElse(null);
		Produit p = Produitrepo.findById(produitId).orElse(null);
		Set<Fournisseur> liste = p.getFournisseur();
		liste.add(f);
		p.setFournisseur(liste);
		
		
	}

	@Override
	public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
