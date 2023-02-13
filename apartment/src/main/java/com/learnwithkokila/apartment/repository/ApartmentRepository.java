package com.learnwithkokila.apartment.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwithkokila.apartment.model.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, UUID> {
	
	List<Apartment> findByClientClientId(UUID clientId);

}
