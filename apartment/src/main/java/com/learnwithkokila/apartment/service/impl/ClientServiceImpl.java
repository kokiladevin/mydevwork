package com.learnwithkokila.apartment.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.learnwithkokila.apartment.exception.ResourceNotFoundException;
import com.learnwithkokila.apartment.model.Apartment;
import com.learnwithkokila.apartment.model.Client;
import com.learnwithkokila.apartment.repository.ApartmentRepository;
import com.learnwithkokila.apartment.repository.ClientRepository;
import com.learnwithkokila.apartment.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	private ClientRepository clientRepository;
	
	public ClientServiceImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	@Override
	public Client saveClient(Client client) {
		System.out.println(client);
		return clientRepository.save(client);
	}

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client getClientById(UUID id) {
		return clientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Client", "Id", id));
	}

	@Override
	public Client updateClient(Client client, UUID id) {
		Client retrievedClient=clientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Client","id", id));
		
		retrievedClient.setEmailId(client.getEmailId());
		retrievedClient.setFirstName(client.getFirstName());
		retrievedClient.setLastName(client.getLastName());
		retrievedClient.setPhoneNumber(client.getPhoneNumber());
				
		return clientRepository.save(retrievedClient);
	}

	@Override
	public void deleteClient(UUID id) {
		if(!clientRepository.existsById(id))
			throw new ResourceNotFoundException("Client","id", id);
		clientRepository.deleteById(id);
	}


}
