package com.api.rentalcars.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.api.rentalcars.model.Client;

import org.springframework.stereotype.Component;

@Component
public class ClientRepository {

	private ArrayList<Client> clients = new ArrayList<>();

	private static int nextCode = 1;

	public List<Client> getAllClients() {
		return clients;
	}

	public Optional<Client> getClientByCode(int id) {
		for(Client aux : clients) {
			if(aux.getCode() == id) {
				return Optional.of(aux);
			}
		}

		return Optional.empty();
	}

	public Client save(Client newClient) {
		newClient.setCode(nextCode++);
		newClient.setTotalValue(0f);
		
		clients.add(newClient);

		return newClient;
	}

	public Client update(Client client) {
		Client aux = getClientByCode(client.getCode()).get();

		if(aux != null) {
			aux.setEmail(client.getEmail());
			aux.setAddress(client.getAddress());
		}

		return aux;
	}

	public void remove(Client client) {
		clients.remove(client);
	}
    
}
