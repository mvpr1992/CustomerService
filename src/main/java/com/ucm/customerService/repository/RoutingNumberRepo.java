package com.ucm.customerService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ucm.customerService.model.entity.RoutingNumbers;

public interface RoutingNumberRepo extends JpaRepository<RoutingNumbers, Integer> {

	@Query(value="select routingnumber from routing_numbers",nativeQuery = true)
	public List<String> findvalidroutingnumbers();
	
	@Query(value="select * from routing_numbers where customer_id = ?1",nativeQuery = true)
	public List<RoutingNumbers> findByCustomerId(int customerId);
}