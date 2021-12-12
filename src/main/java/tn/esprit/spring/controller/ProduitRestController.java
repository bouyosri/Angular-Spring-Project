package tn.esprit.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.ProduitServiceImpl;

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
	
	@ApiOperation(value = "Delete un produit")
	@GetMapping("/delete-produit/{produit-id}")
	@ResponseBody
		public void deleteProduit (@PathVariable("produit-id") Long idProduit) {
		 produitService.deleteProduit(idProduit);
	}
	@ApiOperation(value = "Récupérer un produit")
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
		public Produit retrieveproduit(@PathVariable("produit-id") Long idProduit) {
		return produitService.retrieveProduit(idProduit);
	}
	
	@ApiOperation(value = "Ajouter un produit")
	@PostMapping("/add-produit/{idRayon}/{idStock}")
	@ResponseBody
	public Produit addproduit(@RequestBody  Produit p, @PathVariable Long idRayon, @PathVariable Long idStock)
	{
		Produit produit = produitService.addProduit(p, idRayon, idStock);
		return produit;
	}
	@ApiOperation(value = "Mettre a jour un produit")
	@PutMapping("{produit-id}/assign-stock/{stock-id}")
	@ResponseBody
	public void assignProduitToStock(@PathVariable("produit-id") Long idProduit,
			@PathVariable("stock-id") Long stockId) {
		produitService.assignProduitToStock(idProduit, stockId);
	}
	@ApiOperation(value = "affecter un fournisseur au produit.")
	@PutMapping("{product-id}/affect-fournisseur/{fournisseur-id}")
	@ResponseBody
	public void assignFournisseurToProduit(@PathVariable("produit-id") Long idProduit,
			@PathVariable("fournisseur-id") Long fournisseurId) {
		produitService.assignFournisseurToProduit(idProduit, fournisseurId);
	}
}
