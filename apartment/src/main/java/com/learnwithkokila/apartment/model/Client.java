package com.learnwithkokila.apartment.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="clients")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	@Column(name ="clientid")
	private UUID clientId;
	
	@Column(name ="fistname", nullable=false)
	private String firstName;
	
	@Column(name ="lastname", nullable=false)
	private String lastName;
	
	@Column(name ="email", nullable=false)
	private String emailId;
	
	@Column(name ="phone", nullable=false)
	private String phoneNumber;
	
	@OneToMany
    @JoinColumn(name = "clientid")
    private List<ClientApartment> apartments;
	
	

	public List<ClientApartment> getApartments() {
		return apartments;
	}



	public void setApartments(List<ClientApartment> apartments) {
		this.apartments = apartments;
	}



	public UUID getClientId() {
		return clientId;
	}



	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", phoneNumber=" + phoneNumber + ", apartments=" + apartments + "]";
	}
	
	
	
}
