package com.learnwithkokila.apartment.service;

import java.util.List;
import java.util.UUID;

import com.learnwithkokila.apartment.model.Apartment;
import com.learnwithkokila.apartment.model.Client;

public interface ApartmentService {
	
	Apartment saveApartment(Apartment clientApartment,UUID clientId);
	List<Apartment> getAllApartments(UUID clientId);
	Apartment getApartmentById(UUID id);
	Apartment updateApartment(Apartment apartment, UUID id);
	void deleteApartment(UUID id);
	List<Apartment> getAllApartments();
	List<Apartment> getAllApartments(int rent);
	List<Apartment> getAllApartments(int rent, String city);
}
