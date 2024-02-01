package com.ucm.customerService.model.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "bill_payment")
public class BillPayment {
	
	@Id
	@GeneratedValue
	private int Id;
	private int customerId;
	private String routingNumber;
	private double amount;
	private String status;
	private Date scheduledDate;
	private Date dateOfTransaction;
	
	public BillPayment() {
		
	}

	public BillPayment(int id, int customerId, String routingNumber, double amount, String status, Date scheduledDate,
			Date dateOfTransaction) {
		super();
		Id = id;
		this.customerId = customerId;
		this.routingNumber = routingNumber;
		this.amount = amount;
		this.status = status;
		this.scheduledDate = scheduledDate;
		this.dateOfTransaction = dateOfTransaction;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	@Override
	public String toString() {
		return "BillPayment [Id=" + Id + ", customerId=" + customerId + ", routingNumber=" + routingNumber + ", amount="
				+ amount + ", status=" + status + ", scheduledDate=" + scheduledDate + ", dateOfTransaction="
				+ dateOfTransaction + "]";
	}

}
