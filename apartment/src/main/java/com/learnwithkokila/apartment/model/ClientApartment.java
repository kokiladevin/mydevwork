package com.learnwithkokila.apartment.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "apartments")
public class ClientApartment {
	
	@Id
	@Column(name ="apartmentid")
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID apartmentId;
	
	@Column(name ="description")
	private String description;
	
	@Column(name ="buildingname")
	private String buildingName;
	
	@Column(name ="roomnumber")
	private String roomNumber;
	
	@Column(name ="address")
	private String streetAddress;
	
	@Column(name ="city")
	private String city;
	
	@Column(name ="zipcode")
	private long zipCode;
	
	@Column(name ="isavailable")
	private boolean isAvailableForRent;
	
	@Column(name ="rentprice")
	private int rentPrice;

}
