package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.repository.ProduitRepository;

@Service
public class FournisseurServiceImpl implements FournisseurService {
	@Autowired
	FournisseurRepository FR;
	

	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		// TODO Auto-generated method stub
		return (List<Fournisseur>) this.FR.findAll();
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		// TODO Auto-generated method stub
		return FR.save(f);
	}

	@Override
	public void deleteFournisseur(Long id) {
		// TODO Auto-generated method stub
		FR.deleteById(id);
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		// TODO Auto-generated method stub
		return FR.save(f);
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		// TODO Auto-generated method stub
		return this.FR.findById(id).orElse(null);
	}

	@Scheduled(cron = "*/10 * * * * *" )
	public int getFournisseurssize() {
		List<Fournisseur> List=(java.util.List<Fournisseur>) FR.findAll();
		
		
		System.out.println("scheduled "+List.size());
		return List.size();
		
		

		
	}

	@Override
	public Fournisseur getFournisseursByproduit(Long idProduit) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
