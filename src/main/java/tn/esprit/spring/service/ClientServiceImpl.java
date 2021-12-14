package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.CategorieClient;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> retrieveAllClients() {
		 List<Client> clients=(List<Client>)clientRepository.findAll() ;
		
		 
		 return clients;
	}
	
	

	@Override
	public Client addClient(Client c) {
		return clientRepository.save(c);
		
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);

	}

	@Override
	public Client updateClient(Client c) {
		
		return clientRepository.save(c);
	}

	@Override
	public Client retrieveClient(Long id) {
		
		return clientRepository.findById(id).orElse(null);
	}

	@Override
	public List<Client> getClientWithDate(Date d1 ,Date d2) {
		return clientRepository.retrieveClientsByDateNaissance( d1,d2);

	}



	@Override
	public int nbTotalFacture(Long id) {
		int x= clientRepository.getnbrefacture(id);
		
		return x;
	}



	@Override
	public float totalfactures(Long id) {
		float y=clientRepository.gettotalfacture(id);
		return y;
	}



	@Override
	public float CAT() {
		float y=clientRepository.gettotalfactures();
		return y;
	}



	@Override
	public List<Client> search(String nom) {
	     
		return clientRepository.search(nom);
	}



	@Override
	public List<Client> retrieveClientsByDate(Date d1, Date d2) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Client> retrieveClientsByDate_SQL(Date d1, Date d2) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
