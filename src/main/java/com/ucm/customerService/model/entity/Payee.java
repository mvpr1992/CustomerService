package com.ucm.customerService.model.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Payee {
	
	@Id
	@GeneratedValue
	private int id;
	private int parent_customerId;
	private int child_customerId;
	private Date date;
	
	public Payee() {
		
	}
	
	public Payee(int id, int parent_customerId, int child_customerId, Date date) {
		super();
		this.id = id;
		this.parent_customerId = parent_customerId;
		this.child_customerId = child_customerId;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParent_customerId() {
		return parent_customerId;
	}
	public void setParent_customerId(int parent_customerId) {
		this.parent_customerId = parent_customerId;
	}
	public int getChild_customerId() {
		return child_customerId;
	}
	public void setChild_customerId(int child_customerId) {
		this.child_customerId = child_customerId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Payee [id=" + id + ", parent_customerId=" + parent_customerId + ", child_customerId=" + child_customerId
				+ ", date=" + date + "]";
	}
	
}
