package com.learnwithkokila.apartment.service;

import java.util.List;
import java.util.UUID;

import com.learnwithkokila.apartment.model.Apartment;
import com.learnwithkokila.apartment.model.Client;

public interface ClientService {
	
	Client saveClient(Client client);
	List<Client> getAllClients();
	Client getClientById(UUID id);
	Client updateClient(Client client, UUID id);
	void deleteClient(UUID id);

}
