package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.service.DetailFactureServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "DetailFacture management")
@RequestMapping("/detailfactures")
public class DetailFactureRestController {
	@Autowired
	DetailFactureServiceImpl serviceD;
	
	@ApiOperation(value = "Ajouter un DetailFacture")
	@PostMapping("/add-Detail-Facture/{Facture-id}")
	@ResponseBody
	public DetailFacture addDetailFacture(@RequestBody DetailFacture c,@PathVariable("Facture-id") long idFacture)
	{
		
		DetailFacture DetailFacture = serviceD.addDetailFacture( c, idFacture);
		return DetailFacture;
	}
	
	@ApiOperation(value = "Afficher DetailFactures d'un facture")
	@GetMapping("/retreive-Detail-Facture/{Facture-id}")
	@ResponseBody
	public DetailFacture RetreiveDetailsByFacture(@PathVariable("Facture-id") long idFacture)
	{
		
		DetailFacture liste =serviceD.retrieveDetailFactures(idFacture);
		return liste;
	}
	
	@ApiOperation(value = "Supprimer DetailFactures d'un facture")
	@DeleteMapping("/remove-Detail-Facture/{DFacture-id}")
	@ResponseBody
	public boolean RemoveDetails(@PathVariable("DFacture-id") long idDFacture)
	{
		
		return(serviceD.deleteDetailFacture(idDFacture));
		
	}
	
	
	@ApiOperation(value = "Afficher DetailFactures")
	@GetMapping("/retreive-Details-Facture")
	@ResponseBody
	public ArrayList<DetailFacture> RetreiveDetailsByFacture()
	{
		
		ArrayList<DetailFacture> liste =serviceD.retrieveAllDetailFactures();
		return liste;
	}

}
