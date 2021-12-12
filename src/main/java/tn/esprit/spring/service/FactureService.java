package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.CategorieClient;
import tn.esprit.spring.entity.Facture;



public interface FactureService 
{
	List<Facture> retrieveAllFactures();

	void cancelFacture(Long id);

	Facture retrieveFacture(Long id);	
List<Facture> retrieveFacturesByDates(Date date1, Date date2);
	
	List<Facture> getFacturesByClient(Long idClient);
	
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate);
	
	float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);

}
