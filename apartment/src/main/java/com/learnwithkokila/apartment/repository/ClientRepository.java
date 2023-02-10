package com.learnwithkokila.apartment.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwithkokila.apartment.model.Client;

public interface ClientRepository extends JpaRepository<Client,UUID> {

}
