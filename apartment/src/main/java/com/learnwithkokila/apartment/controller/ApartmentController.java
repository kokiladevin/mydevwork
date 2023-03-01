package com.learnwithkokila.apartment.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithkokila.apartment.model.Apartment;
import com.learnwithkokila.apartment.service.ApartmentService;

@RestController
@RequestMapping("apartmentapi/clients/apartments")
public class ApartmentController {
	
	private ApartmentService apartmentService;
	
		
	public ApartmentController(ApartmentService apartmentService) {
		super();
		this.apartmentService = apartmentService;
	}


//	@GetMapping()
//	public List<Apartment> getAllApartments()
//	{
//		return apartmentService.getAllApartments();
//	}
	
	@GetMapping()
	public List<Apartment> getAllApartments(@RequestParam(name = "rent", required = false) String rent)
	{
		if (rent != null)
			return apartmentService.getAllApartments(Integer.parseInt(rent));
		else
			return apartmentService.getAllApartments();
		
	}
	
	@GetMapping("{id}")
	public Apartment getApartment(@PathVariable("id") UUID apartmentId)
	{
		return apartmentService.getApartmentById(apartmentId);
	}
	
	@PutMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Apartment> updateApartment(@PathVariable ("id") UUID apartmentId, @RequestBody Apartment apartment)
	{
		return new ResponseEntity<Apartment>(apartmentService.updateApartment(apartment, apartmentId),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteApartment(@PathVariable("id") UUID apartmentId)
	{
		apartmentService.deleteApartment(apartmentId);
		return new ResponseEntity<String>("Apartment Deleted Successfully",HttpStatus.OK);
	}

}
