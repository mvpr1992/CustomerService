package com.ucm.customerService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ucm.customerService.model.entity.CreditCard;

public interface CreditCardRepo extends JpaRepository<CreditCard, Integer> {

	@Query(value = "select * from credit_card where application_id = (select max(application_id) from credit_card where customer_id = ?1)", nativeQuery = true)
	public CreditCard getcreditcardstatus(int customerId);
	
	public List<CreditCard> findByManagerIdAndStatus(int managerId,String Status);
	
	@Query(value = "select * from credit_card where customer_id = ?1 and status = 'V'", nativeQuery = true)
	public List<CreditCard> isccApproved(int customerId);
	
}
