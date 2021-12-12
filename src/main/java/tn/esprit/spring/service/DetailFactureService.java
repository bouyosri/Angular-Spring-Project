package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;

public interface DetailFactureService {
	
	public ArrayList<DetailFacture> retrieveDetailFacturesbyFacture(Long idFacture);
	
	public ArrayList<DetailFacture> retrieveAllDetailFactures();
	
	public DetailFacture retrieveDetailFactures(Long idDFacture);

	public DetailFacture addDetailFacture(DetailFacture c,Long idFacture);

	public boolean deleteDetailFacture(Long id);

	public DetailFacture updateDetailFacture(DetailFacture c);

	void CalculTotal(float total, float Remise, Facture f);
	
}
