package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Produit;


public interface ProduitService {
	
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p, Long idRayon, Long idStock);

	Produit retrieveProduit(Long id);
	
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;
	
	float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);

}
