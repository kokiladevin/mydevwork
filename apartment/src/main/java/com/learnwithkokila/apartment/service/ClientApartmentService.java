package com.learnwithkokila.apartment.service;

import java.util.List;
import java.util.UUID;

import com.learnwithkokila.apartment.model.ClientApartment;

public interface ClientApartmentService {
	
	ClientApartment saveClientApartment(ClientApartment clientApartment);
	List<ClientApartment> getAllApartments(UUID clientId);
	

}
