package tn.esprit.spring.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import io.swagger.models.Model;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.service.FournisseurServiceImpl;
import tn.esprit.spring.service.FournisseurService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
 @Api(tags = "Fournissseur management")
@RequestMapping("/fournissseur")
public class FournisseurRestController {

	@Autowired
	FournisseurServiceImpl fournissseurService;
	 
	@ApiOperation(value = "Récupérer la liste des fournissseurs")
	@GetMapping("/retrieve-all-fournissseurs")
	@ResponseBody
	public List<Fournisseur> getFournisseurs() {
	List<Fournisseur> listFournisseurs = fournissseurService.retrieveAllFournisseurs();
	return listFournisseurs;
	}
	 
	@ApiOperation(value = "Récupérer un fournissseur par Id")
	@GetMapping("/retrieve-fournissseur/{fournissseur-id}")
	@ResponseBody
	public Fournisseur retrieveFournissseur(@PathVariable("fournissseur-id") Long fournissseurId) {
	return fournissseurService.retrieveFournisseur(fournissseurId);
	}
	 
	@ApiOperation(value = "Ajouter un nouveau fournissseur")
	@PostMapping("/add-fournissseur")
	@ResponseBody
	public Fournisseur addFournisseur(@RequestBody Fournisseur f)
	{
		Fournisseur fournissseur = fournissseurService.addFournisseur(f);
		return fournissseur;
	}
	 
	@ApiOperation(value = "Supprimer un fournissseur par Id")
	@DeleteMapping("/remove-fournissseur/{fournissseur-id}")
	@ResponseBody
	public void removeFournisseur(@PathVariable("fournissseur-id") Long fournissseurId) {
	fournissseurService.deleteFournisseur(fournissseurId);
	}

	@ApiOperation(value = "Mettre a jour un fournissseur")
	@PutMapping("/modify-fournissseur")
	@ResponseBody
	public Fournisseur modifyFournisseur(@RequestBody Fournisseur f) {
		System.out.println(f.getIdFournisseur());
	return fournissseurService.updateFournisseur(f);
	
	}

	@ApiOperation(value = "Récupérer la liste des fournisseurs")
	@GetMapping("/retrieve-all-fournisseurs-size/")
	@ResponseBody
	public int getFournisseurssize() {
		System.out.println(fournissseurService.getFournisseurssize());
	return fournissseurService.getFournisseurssize();
	}
	 
	
}
