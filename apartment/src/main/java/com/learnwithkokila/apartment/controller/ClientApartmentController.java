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

import com.learnwithkokila.apartment.model.Apartment;
import com.learnwithkokila.apartment.service.ApartmentService;

@RestController
@RequestMapping("/apartmentapi/clients/{id}/apartments")
public class ClientApartmentController {
	
	private ApartmentService apartmentService;
	
	public ClientApartmentController(ApartmentService apartmentService) {
		super();
		this.apartmentService = apartmentService;
	}


	@GetMapping()
	public List<Apartment> getAllApartments(@PathVariable("id") UUID clientId)
	{
		return apartmentService.getAllApartments(clientId);
	}
	
	@GetMapping("{apartmentId}")
	public Apartment getApartmentById(@PathVariable("apartmentId") UUID apartmentId)
	{
		return apartmentService.getApartmentById(apartmentId);
	}
	
	@PostMapping()
	public ResponseEntity<Apartment> saveApartment(@RequestBody Apartment apartment, @PathVariable("id") UUID clientId)
	{
		System.out.println(apartment);
		return new ResponseEntity<Apartment>(apartmentService.saveApartment(apartment, clientId),HttpStatus.CREATED);
	}
	
	@PutMapping("{apartmentId}")
	public ResponseEntity<Apartment> updateApartment(@RequestBody Apartment apartment, @PathVariable("apartmentId") UUID apartmentId)
	{
		return new ResponseEntity<Apartment>(apartmentService.updateApartment(apartment, apartmentId),HttpStatus.OK);
	}
	
	@DeleteMapping("{apartmentId}")
	public String deleteApartmentById(@PathVariable("apartmentId") UUID apartmentId)
	{
		apartmentService.deleteApartment(apartmentId);
		return "Apartment deleted successfully";
	}
	
	

}
