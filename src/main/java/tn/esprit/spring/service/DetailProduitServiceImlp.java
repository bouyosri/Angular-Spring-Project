package tn.esprit.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.repository.DetailProduitRepository;

@Service
public class DetailProduitServiceImlp implements DetailProduitService {
	@Autowired
	DetailProduitRepository DPR;

	@Override
	public List<DetailProduit> retrieveAllPrdoDetails() {
		// TODO Auto-generated method stub
		return (List<DetailProduit>) DPR.findAll();
	}

	@Override
	public DetailProduit addProdDetail(DetailProduit dp) {
		// TODO Auto-generated method stub
		return DPR.save(dp);
	}

	@Override
	public void deleteProdDetail(Long id) {
		// TODO Auto-generated method stub
		DPR.deleteById(id);
	}

	@Override
	public DetailProduit updateProdDetail(DetailProduit dp) {
		// TODO Auto-generated method stub
		return DPR.save(dp);
	}

	@Override
	public DetailProduit retrieveProdDetail(Long id) {
		// TODO Auto-generated method stub
		return this.DPR.findById(id).orElse(null);
	}

	

}
