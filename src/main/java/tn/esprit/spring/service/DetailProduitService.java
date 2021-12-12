package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.entity.Produit;

public interface DetailProduitService {
	List<DetailProduit> retrieveAllPrdoDetails();

	DetailProduit addProdDetail(DetailProduit dp);

	void deleteProdDetail(Long id);

	DetailProduit updateProdDetail(DetailProduit dp);

	DetailProduit retrieveProdDetail(Long id);




}
