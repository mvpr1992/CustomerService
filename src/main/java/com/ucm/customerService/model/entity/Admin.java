package com.ucm.customerService.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue
	private int adminId;
	private String name;
	private String userId;
	private String password;
	
	public Admin() {
		
	}
	
	public Admin(int adminId, String name, String userId, String password) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.userId = userId;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
		return "Admin [adminId=" + adminId + ", name=" + name + ", userId=" + userId + ", password=" + password + "]";
	}

}
