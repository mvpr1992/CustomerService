package com.ucm.customerService.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Manager {
	
	@Id
	@GeneratedValue
	private int managerId;
	private String name;
	private String userId;
	private String password;
	
	public Manager() {
		
	}
	
	public Manager(int managerId, String name, String userId, String password) {
		super();
		this.managerId = managerId;
		this.name = name;
		this.userId = userId;
		this.password = password;
	}

	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", name=" + name + ", userId=" + userId + ", password=" + password
				+ "]";
	}

}
