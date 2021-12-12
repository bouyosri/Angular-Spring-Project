package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.service.ClientServiceImpl;
import tn.esprit.spring.service.StockServiceImpl;


@RestController
@Api(tags = "Client management")
@RequestMapping("/clients")
public class ClientRestController {
	@Autowired
	
	ClientServiceImpl clientService;
	
	@ApiOperation(value = "Récupérer la liste des clients")
	@GetMapping("/retrieve-all-clients")
	@ResponseBody
	public List<Client> getAllClients() {
		List<Client> clients = clientService.retrieveAllClients();
		return clients;
	}
	
	@ApiOperation(value = "Récupérer un client")
	@GetMapping("/retrieve-client/{client-id}")
	@ResponseBody
		public Client retrieveClient(@PathVariable("client-id") Long clientId) {
		return clientService.retrieveClient(clientId);
	}
	
	@ApiOperation(value = "Ajouter un client")
	@PostMapping("/add-client")
	@ResponseBody
	public Client addClient(@RequestBody Client c)
	{
		Client client = clientService.addClient(c);
		return client;
	}
	
	@ApiOperation(value = "Modifier un client")
	@PutMapping("/modify-client")
	@ResponseBody
	public Client modifyClient(@RequestBody Client client) {
	return clientService.updateClient(client);
	}
	
	@ApiOperation(value = "Supprimer un client")
	@DeleteMapping("/remove-client/{client-id}")
	@ResponseBody
	public void removeClient(@PathVariable("client-id") Long clientId) {
	clientService.deleteClient(clientId);
	}
	

}
