package com.api.rentalcars.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.api.rentalcars.model.Client;

import org.springframework.stereotype.Component;

@Component
public class ClientRepository {

	private ArrayList<Client> clients = new ArrayList<>();

	private int nextID = 1;

	public List<Client> getAllClients() {
		return clients;
	}

	public Optional<Client> getClientByID(int id) {
		for(Client aux : clients) {
			if(aux.getCode() == id) {
				return Optional.of(aux);
			}
		}

		return Optional.empty();
	}

	public Client save(Client newClient) {
		newClient.setCode(nextID++);
		clients.add(newClient);

		return newClient;
	}
    
}
