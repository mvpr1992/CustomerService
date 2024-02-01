package com.ucm.customerService.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class RoutingNumbers {
	
	@Id
	@GeneratedValue
	private int id;
	private int customerId;
	private String routingnumber;
	private String utilityname;
	
	public RoutingNumbers() {
		
	}
	
	public RoutingNumbers(int id, int customerId, String routingnumber, String utilityname) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.routingnumber = routingnumber;
		this.utilityname = utilityname;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUtilityname() {
		return utilityname;
	}

	public void setUtilityname(String utilityname) {
		this.utilityname = utilityname;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoutingnumber() {
		return routingnumber;
	}
	public void setRoutingnumber(String routingnumber) {
		this.routingnumber = routingnumber;
	}

	@Override
	public String toString() {
		return "RoutingNumbers [id=" + id + ", customerId=" + customerId + ", routingnumber=" + routingnumber
				+ ", utilityname=" + utilityname + "]";
	}
	
}
