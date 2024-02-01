package com.ucm.customerService.model.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "credit_card")
public class CreditCard {
	
	@Id
	@GeneratedValue
	private int applicationId;
	private int customerId;
	private int managerId;
	private double max_limit;
	private String status;
	private Date date;
	
	
	public CreditCard() {
		
	}
	
	public CreditCard(int applicationId, int customerId, int managerId, double max_limit, String status,
			Date date) {
		super();
		this.applicationId = applicationId;
		this.customerId = customerId;
		this.managerId = managerId;
		this.max_limit = max_limit;
		this.status = status;
		this.date = date;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getMax_limit() {
		return max_limit;
	}

	public void setMax_limit(double max_limit) {
		this.max_limit = max_limit;
	}
	
	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	@Override
	public String toString() {
		return "CreditCard [applicationId=" + applicationId + ", customerId=" + customerId + ", status=" + status + ", date=" + date + "]";
	}
	
}
