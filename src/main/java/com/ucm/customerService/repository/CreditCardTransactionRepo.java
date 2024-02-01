package com.ucm.customerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ucm.customerService.model.entity.CreditCardTransaction;

public interface CreditCardTransactionRepo extends JpaRepository<CreditCardTransaction, Integer> {

	@Query(value="select * from credit_card_transaction where id = (select max(id) from credit_card_transaction where customer_id = ?1)", nativeQuery = true)
	public CreditCardTransaction findmaxTransactionUserbyCustomerId(int customerId);	
}
