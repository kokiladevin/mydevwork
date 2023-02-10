package com.learnwithkokila.apartment.service.impl;

import org.springframework.stereotype.Service;

import com.learnwithkokila.apartment.model.Client;
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

}
