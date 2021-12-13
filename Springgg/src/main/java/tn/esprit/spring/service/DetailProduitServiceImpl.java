package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.repository.DetailProduitRepository;

@Service
public class DetailProduitServiceImpl  implements DetailProduitService{
 @Autowired
	DetailProduitRepository detailProduitRepository;
	@Override
	public DetailProduit addDetailProduit(DetailProduit d) {
		
	  System.out.println("wissem");
	  System.out.println(d.getCategorieProduit());
	  System.out.println(d.getDateCreation());
	  System.out.println(d.getDateDerniereModification());
	  System.out.println(d.getIdDetailProduit());
	  System.out.println(d.getProduit().getCode());
	  detailProduitRepository.save(d);
		return d;
	}

}
