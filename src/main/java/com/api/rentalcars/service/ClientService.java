package com.api.rentalcars.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.api.rentalcars.model.Client;
import com.api.rentalcars.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	public List<Client> getAllClients() {
		return repository.getAllClients();
	}

	public Client getClientByID(int id) {
		Optional<Client> op = repository.getClientByID(id);
		

		return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not registered: " + id));
	}

	public Client save(Client newClient) {
		return repository.save(newClient);
	}

	public Client fromDTO(Client changesClient) {
		Client aux = new Client();
		
		aux.setEmail(changesClient.getEmail());
		aux.setAddress(changesClient.getAddress());

		return aux;
	}

	public Client update(Client aux) {
		return null;
	}
    
}
