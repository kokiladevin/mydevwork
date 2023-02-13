package com.learnwithkokila.apartment.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.learnwithkokila.apartment.model.ClientApartment;
import com.learnwithkokila.apartment.repository.ApartmentRepository;
import com.learnwithkokila.apartment.service.ClientApartmentService;

@Service
public class ClientApartmentServiceImpl implements ClientApartmentService {
	
	public ApartmentRepository apartmentRepository;
	
	public ClientApartmentServiceImpl(ApartmentRepository apartmentRepository) {
		super();
		this.apartmentRepository = apartmentRepository;
	}

	@Override
	public List<ClientApartment> getAllApartments(UUID clientId) {
		
		return apartmentRepository.findById(clientId).stream().collect(Collectors.toList());
		
	}
	
	@Override
	public ClientApartment saveClientApartment(ClientApartment clientApartment) {
		System.out.println(clientApartment);
		return apartmentRepository.save(clientApartment);
	}

	
}
