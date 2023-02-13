package com.learnwithkokila.apartment.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithkokila.apartment.model.ClientApartment;
import com.learnwithkokila.apartment.service.ClientApartmentService;

@RestController
@RequestMapping("/apartmentapi/clients/{id}/apartments")
public class ApartmentController {
	
	private ClientApartmentService clientApartmentService;
	
	public ApartmentController(ClientApartmentService clientApartmentService) {
		super();
		this.clientApartmentService = clientApartmentService;
	}


	@GetMapping()
	List<ClientApartment> getAllApartment(@PathVariable("id") UUID clientId)
	{
		return clientApartmentService.getAllApartments(clientId);
	}

}
