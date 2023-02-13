package com.learnwithkokila.apartment.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.learnwithkokila.apartment.exception.ResourceNotFoundException;
import com.learnwithkokila.apartment.model.Apartment;
import com.learnwithkokila.apartment.model.Client;
import com.learnwithkokila.apartment.repository.ApartmentRepository;
import com.learnwithkokila.apartment.repository.ClientRepository;
import com.learnwithkokila.apartment.service.ApartmentService;

@Service
public class ApartmentServiceImpl implements ApartmentService {
	
	public ApartmentRepository apartmentRepository;
	public ClientRepository clientRepository;
	
	public ApartmentServiceImpl(ApartmentRepository apartmentRepository, ClientRepository clientRepository) {
		super();
		this.apartmentRepository = apartmentRepository;
		this.clientRepository=clientRepository;
	}

	@Override
	public List<Apartment> getAllApartments(UUID clientId) {
		return apartmentRepository.findByClientClientId(clientId);
	}
	
	@Override
	public Apartment saveApartment(Apartment apartment, UUID clientId) {
		
		Client client=clientRepository.findById(clientId).orElseThrow(()->new ResourceNotFoundException("Client", "Id", clientId));
		apartment.setClient(client);
		return apartmentRepository.save(apartment);
	}

	@Override
	public Apartment getApartmentById(UUID apartmentId) {
		return apartmentRepository.findById(apartmentId).orElseThrow(()->new ResourceNotFoundException("Apartment", "Id", apartmentId));
	}

	@Override
	public Apartment updateApartment(Apartment apartment, UUID apartmentId) {
		Apartment retrievedApartment = apartmentRepository
										.findById(apartmentId)
										.orElseThrow(()->new ResourceNotFoundException("Apartment", "Id", apartmentId));
		retrievedApartment.setAvailableForRent(apartment.isAvailableForRent());
		retrievedApartment.setBuildingName(apartment.getBuildingName());
		retrievedApartment.setCity(apartment.getCity());
		retrievedApartment.setDescription(apartment.getDescription());
		retrievedApartment.setRentPrice(apartment.getRentPrice());
		retrievedApartment.setRoomNumber(apartment.getRoomNumber());
		retrievedApartment.setStreetAddress(apartment.getStreetAddress());
		retrievedApartment.setZipCode(apartment.getZipCode());
		return apartmentRepository.save(retrievedApartment);
	}

	@Override
	public void deleteApartment(UUID apartmentId) {
		if(!apartmentRepository.existsById(apartmentId))
			throw new ResourceNotFoundException("Apartment", "ID", apartmentId);
		apartmentRepository.deleteById(apartmentId);
		
	}

	
}
