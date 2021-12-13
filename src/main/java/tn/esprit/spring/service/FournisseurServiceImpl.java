package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.repository.FournisseurRepository;

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

  /*@Override
	public List<Fournisseur> getFournisseursByproduit(Long idProduit) {
		// TODO Auto-generated method stub
		return FR.getFournisseursByproduit(idProduit);
	}
	*/

}
