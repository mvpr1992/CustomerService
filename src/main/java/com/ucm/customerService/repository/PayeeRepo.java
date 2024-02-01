package com.ucm.customerService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ucm.customerService.model.entity.Payee;

public interface PayeeRepo extends JpaRepository<Payee, Integer> {

	@Query(value="select child_customer_id from payee where parent_customer_id = ?1",nativeQuery = true)
	public List<Integer> findaddedcustomeridlist(int customerId);
}