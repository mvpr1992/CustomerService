package com.ucm.customerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ucm.customerService.model.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
	
}
