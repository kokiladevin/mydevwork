package com.learnwithkokila.apartment.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithkokila.apartment.model.Client;
import com.learnwithkokila.apartment.model.Apartment;
import com.learnwithkokila.apartment.service.ApartmentService;
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

	@GetMapping()
	public List<Client> getAllClients()
	{
		return clientService.getAllClients();
	}
	
		
	@GetMapping("{id}")
	public ResponseEntity<Client> getClientById(@PathVariable("id") UUID clientId)
	{
		return new ResponseEntity<Client>(clientService.getClientById(clientId),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") UUID clientId,
											   @RequestBody Client client)
	{
		return new ResponseEntity<Client>(clientService.updateClient(client, clientId),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteClient(@PathVariable("id") UUID clientId)
	{
		clientService.deleteClient(clientId);
		return new ResponseEntity<String>("Client Deleted Successfully",HttpStatus.OK);
	}
}
