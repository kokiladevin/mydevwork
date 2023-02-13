package com.learnwithkokila.apartment.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "apartments")
public class Apartment {
	
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
	private boolean availableForRent;
	
	@Column(name ="rentprice")
	private int rentPrice;
	
	
	@ManyToOne
	@JoinColumn(name = "clientid")
	private Client client;
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "ClientApartment [apartmentId=" + apartmentId + ", description=" + description + ", buildingName="
				+ buildingName + ", roomNumber=" + roomNumber + ", streetAddress=" + streetAddress + ", city=" + city
				+ ", zipCode=" + zipCode + ", availableForRent=" + availableForRent + ", rentPrice=" + rentPrice
				+ "]";
	}

	public UUID getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(UUID apartmentId) {
		this.apartmentId = apartmentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public boolean isAvailableForRent() {
		return availableForRent;
	}

	public void setAvailableForRent(boolean availableForRent) {
		this.availableForRent = availableForRent;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	

}
