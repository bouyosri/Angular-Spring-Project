

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
 
import tn.esprit.spring.entity.Rayon;
 
import tn.esprit.spring.service.RayonServiceImpl;

@CrossOrigin
@RestController
@Api(tags = "Rayon management")
@RequestMapping("/rayon")
public class RayonRestController {

	@Autowired
	RayonServiceImpl RayonService;
	
	@ApiOperation(value = "Récupérer la liste des Rayons")
	@GetMapping("/retrieve-all-rayons")
	@ResponseBody
	public List<Rayon> getRayons() {
	List<Rayon> listRayon = RayonService.retrieveAllRayons();
	return listRayon;
	}
	
	@ApiOperation(value = "Récupérer un Rayon par Id")
	@GetMapping("/retrieve-rayon/{rayon-id}")
	@ResponseBody
	public Rayon retrievRayon(@PathVariable("rayon-id") Long RayonId) {
	return RayonService.retrieveRayon(RayonId);
	}
	
	@ApiOperation(value = "Ajouter un nouveau rayon")
	@PostMapping("/add-rayon")
	@ResponseBody
	public Rayon addRayon(@RequestBody Rayon f)
	{
		Rayon rayon = RayonService.addRayon(f);
		return rayon;
	}
	
	@ApiOperation(value = "Supprimer un rayon par Id")
	@DeleteMapping("/remove-rayon/{rayon-id}")
	@ResponseBody
	public void removeFournisseur(@PathVariable("rayon-id") Long rayonid) {
	RayonService.deleteRayon(rayonid);
	}

	@ApiOperation(value = "Mettre a jour un rayon")
	@PutMapping("/modify-rayon")
	@ResponseBody
	public Rayon modifyFournisseur(@RequestBody Rayon f) {
	return RayonService.updateRayon(f);
	}
	
	 
	
}
