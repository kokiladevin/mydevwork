package com.learnwithkokila.apartment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithkokila.apartment.model.Client;
import com.learnwithkokila.apartment.service.ClientService;

@RestController
@RequestMapping("/apartmentapi/clients")
public class ClientController {
	
	private ClientService clientService;

	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}
	
	@PostMapping()
	public ResponseEntity<Client> saveClient(@RequestBody Client client)
	{
		System.out.println(client);
		return new ResponseEntity<Client>(clientService.saveClient(client),HttpStatus.CREATED); 
	}

}
