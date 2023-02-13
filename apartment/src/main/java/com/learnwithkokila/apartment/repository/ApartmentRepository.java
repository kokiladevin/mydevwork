package com.learnwithkokila.apartment.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwithkokila.apartment.model.ClientApartment;

public interface ApartmentRepository extends JpaRepository<ClientApartment, UUID> {

}
