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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "Client management")
@RequestMapping("/clients")
public class ClientRestController {

		@Autowired
		ClientServiceImpl clientService;
		
		// http://localhost:8013/SpringMVC/client/retrieve-all-clients
		@GetMapping("/retrieve-all-clients")
		@ResponseBody
		public List<Client>getClients() {
		List<Client> listClients = clientService.retrieveAllClients();
		return listClients;
		}
		
		
		@GetMapping("/searchclient/{nom}")
		@ResponseBody
		public List<Client>search(@PathVariable("nom") String nom) {
		List<Client> listClients = clientService.search(nom);
		return listClients;
		}
		
		
		
		//http://localhost:8013/SpringMVC/client/retrieve-client/1
		@GetMapping("/retrieve-client/{client-id}")
		@ResponseBody
		public Client retrieveClient(@PathVariable("client-id") Long clientId) {
		return clientService.retrieveClient(clientId);
		}
		
		
		@GetMapping("/nbfacture/{client-id}")
		@ResponseBody
		public int retrieveClientFactureNbr(@PathVariable("client-id") Long clientId) {
		return clientService.nbTotalFacture(clientId);
		}
		
		@GetMapping("/totalfactures/{client-id}")
		@ResponseBody
		public float retrieveClientFactureTotal(@PathVariable("client-id") Long clientId) {
		return clientService.totalfactures(clientId);
		}
		
		@GetMapping("/CAT")
		@ResponseBody
		public float FactureTotal() {
		return clientService.CAT();
		}
		
		// http://localhost:8013/SpringMVC/client/add-client
		@PostMapping("/add-client")
		@ResponseBody
		public Client addClient(@RequestBody Client c)
		{
		Client client = clientService.addClient(c);
		return client;
		}
		
		
		
		//http://localhost:8013/SpringMVC/client/remove-client/{client-id}
		@DeleteMapping("/remove-client/{client-id}")
		@ResponseBody
		public void removeClient(@PathVariable("client-id") Long clientId) {
		clientService.deleteClient(clientId);
		}
		
		//http://localhost:8013/SpringMVC/client/modify-client
		@PutMapping("/modify-client")
		@ResponseBody
		public Client modifyClient(@RequestBody Client client) {
		return clientService.updateClient(client);
		}
		



}
