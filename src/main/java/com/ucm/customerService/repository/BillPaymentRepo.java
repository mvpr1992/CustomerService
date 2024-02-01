package com.ucm.customerService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ucm.customerService.model.entity.BillPayment;

public interface BillPaymentRepo extends JpaRepository<BillPayment, Integer> {

	@Query(value="select * from bill_payment where status = 'P'", nativeQuery = true)
	public List<BillPayment> getPendingBillPayments();
}