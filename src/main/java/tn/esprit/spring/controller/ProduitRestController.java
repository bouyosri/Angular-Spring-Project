package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.ProduitServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "Produits management")
@RequestMapping("/produits")
public class ProduitRestController {
	
	
@Autowired
	
	ProduitServiceImpl produitService;

	
	@ApiOperation(value = "Récupérer la liste des produits")
	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getAllproduits() {
		List<Produit> produits = produitService.retrieveAllProduits();
		return produits;
	}
	
	@ApiOperation(value = "Récupérer un produit")
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
		public Produit retrieveproduit(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}
	
	@ApiOperation(value = "Ajouter un produit")
	@PostMapping("/add-produit/{idRayon}/{idStock}")
	@ResponseBody
	public Produit addproduit(@RequestBody Produit c,@PathVariable Long idRayon,@PathVariable Long idStock)
	{
		Produit produit = produitService.addProduit(c, idRayon, idStock);
		return produit;
	}

}
