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
	
	@Override
	public String toString() {
		return "ClientApartment [apartmentId=" + apartmentId + ", description=" + description + ", buildingName="
				+ buildingName + ", roomNumber=" + roomNumber + ", streetAddress=" + streetAddress + ", city=" + city
				+ ", zipCode=" + zipCode + ", isAvailableForRent=" + isAvailableForRent + ", rentPrice=" + rentPrice
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
		return isAvailableForRent;
	}

	public void setAvailableForRent(boolean isAvailableForRent) {
		this.isAvailableForRent = isAvailableForRent;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	@Column(name ="zipcode")
	private long zipCode;
	
	@Column(name ="isavailable")
	private boolean isAvailableForRent;
	
	@Column(name ="rentprice")
	private int rentPrice;

}
