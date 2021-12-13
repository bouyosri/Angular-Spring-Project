package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.service.FactureServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "Facture management")
@RequestMapping("/factures")
public class FactureRestController {
	
	@Autowired
	FactureServiceImpl FactureService;
	
	
	
	@ApiOperation(value = "Récupérer la liste des Factures")
	@GetMapping("/retrieve-all-Factures")
	@ResponseBody
	public List<Facture> getAllFactures() {
		List<Facture> Factures = FactureService.retrieveAllFactures();
		return Factures;
	}
	
	@ApiOperation(value = "Récupérer un Facture")
	@GetMapping("/retrieve-Facture/{Facture-id}")
	@ResponseBody
		public Facture retrieveFacture(@PathVariable("Facture-id") Long FactureId) {
		return FactureService.retrieveFacture(FactureId);
	}
	
	@ApiOperation(value = "Ajouter un Facture")
	@PostMapping("/add-Facture/{Client-id}")
	@ResponseBody
	public Facture addFacture(@RequestBody Facture f,@PathVariable("Client-id") long idclient)
	{
		Facture Facture = FactureService.addFacture(f, idclient);
		return Facture;
	}
	
	@ApiOperation(value = "Pay Facture")
	@PostMapping("/pay-Facture/{facture-id}")
	@ResponseBody
	public void payFacture(@PathVariable("facture-id") long idfacture)
	{
		FactureService.cancelFacture(idfacture);
	}
	
	@ApiOperation(value = "Supprimer un Facture")
	@DeleteMapping("/remove-Facture/{Facture-id}")
	@ResponseBody
		public void removeFacture(@PathVariable("Facture-id") Long FactureId) {
		 FactureService.RemoveFacture(FactureId);
	}

}
