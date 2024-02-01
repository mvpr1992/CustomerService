package com.ucm.customerService.model.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CreditCardTransaction {
	
	@Id
	@GeneratedValue
	private int id;
	private int customerId;
	private String description;
	private double amount;
	private Date date;
	private double availablelimit;
	private String message;
	
	public CreditCardTransaction() {
		
	}
	
	public CreditCardTransaction(int id, int customerId, String description, double amount, double availablelimit, Date date, String message) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.description = description;
		this.amount = amount;
		this.message = message;
	}
	
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAvailablelimit() {
		return availablelimit;
	}

	public void setAvailablelimit(double availablelimit) {
		this.availablelimit = availablelimit;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CreditCardTransaction [id=" + id + ", customerId=" + customerId + ", description=" + description
				+ ", amount=" + amount + "]";
	}

}
