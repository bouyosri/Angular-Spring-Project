package tn.esprit.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;



public interface FactureService 
{
	public List<Facture> retrieveAllFactures();
	public List<Facture> retrieveFacturesPaid();
	public List<Facture> retrieveFacturesUnpaid();

	void cancelFacture(Long id);

	Facture retrieveFacture(Long id);	
	
	public List<Facture> getFacturesByClient(Long idClient);
	
	public Facture addFacture(Facture f, Long idClient);

	Facture addDetailsFacture(Facture f, Set<DetailFacture> detailsFacture);
	
	public void RemoveFacture(Long id);
}
