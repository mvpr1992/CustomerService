package com.ucm.customerService.model.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "usersignup")
public class UserSignup {
	
	public UserSignup() {
		
	}

	@Id
	@GeneratedValue
	private int customerId;
	private String firstName;
	private String lastName;
	private String userId;
	private String password;
	private String mobile;
	private String email;
	private String mailingAddress;
	private int zipCode;
	private String city;
	private String country;
	private String status;
    
    public UserSignup(int customerId, String firstName,String lastName,String userId, String password,
    		Date dateOfBirth,String mobile, String email, String mailingAddress, int zipCode, String city, 
    		String country, String status) {
       
    	this.customerId = customerId;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.userId = userId;
    	this.password = password;
    	this.mobile = mobile;
    	this.email = email;
    	this.mailingAddress= mailingAddress;
    	this.zipCode = zipCode;
    	this.city = city;
    	this.country = country;
    	this.status = status;
    }
    
	

	public int getCustomerId() {
		return customerId;
	}




	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getMobile() {
		return mobile;
	}




	public void setMobile(String mobile) {
		this.mobile = mobile;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getMailingAddress() {
		return mailingAddress;
	}




	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}




	public int getZipCode() {
		return zipCode;
	}




	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
    public String toString() {
        return new StringBuilder("{customerId: ").append(customerId).append(", firstName: ")
                .append(firstName).append(", lastName: ").append(lastName).append("}").toString();
    }
}
