package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.service.DetailProduitServiceImpl;
import tn.esprit.spring.service.ProduitServiceImpl;

@RestController
@RequestMapping("/produit")
public class ProduitController {
	
	@Autowired
	ProduitServiceImpl serviceproduit;

	// http://localhost:8013/SpringMVC/produit/add-produit/1/1
	@PostMapping("/add-produit/{idr}/{ids}")
	@ResponseBody
	public Produit aa(@RequestBody Produit p, @PathVariable Long idr,@PathVariable Long ids)
	{
	return  serviceproduit.test(p,idr,ids);
	
	}



}
