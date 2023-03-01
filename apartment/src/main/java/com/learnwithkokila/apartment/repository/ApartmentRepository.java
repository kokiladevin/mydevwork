package com.learnwithkokila.apartment.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learnwithkokila.apartment.model.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, UUID> {
	
	List<Apartment> findByClientClientId(UUID clientId);
	
	@Query("select a from Apartment a where a.rentPrice < ?1 order by a.zipCode ")
	List<Apartment> findAll(int rent);
	
	@Query("select a from Apartment a where a.rentPrice < ?1 and a.city = ?2  ")
	List<Apartment> findAll(int rent, String city);

}
