package com.api.rentalcars.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.api.rentalcars.dto.ClientDTO;
import com.api.rentalcars.model.Client;
import com.api.rentalcars.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
<<<<<<< HEAD
=======
import org.springframework.stereotype.Service;
>>>>>>> cdc71c1fa8fc4b38d06d2bfbfc7e1436c06b2bcd
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAllClients() {
		return clientRepository.getAllClients();
	}

	public Client getClientByCode(int id) {
		Optional<Client> op = clientRepository.getClientByCode(id);

		return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not registered: " + id));
	}

	public Client save(Client newClient) {
		return clientRepository.save(newClient);
	}

	public Client fromDTO(ClientDTO client) {
		Client aux = new Client();
		
		aux.setName(client.getName());
		aux.setCpf(client.getCpf());
		aux.setDateOfBirth(client.getDateOfBirth());
		aux.setEmail(client.getEmail());
		aux.setAddress(client.getAddress());

		return aux;
	}
	
	public Client update(Client client) {
		getClientByCode(client.getCode());

		return clientRepository.update(client);
	}

	public void removeClient(Client client) {
		clientRepository.remove(getClientByCode(client.getCode()));
	}
    
}
