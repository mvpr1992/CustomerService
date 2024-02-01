package com.ucm.customerService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ucm.customerService.model.entity.Customer;

public interface UserRepo extends JpaRepository<Customer, Integer> {
	
	Customer findByUserId(String userId);
	
	Customer findByUserIdAndPassword(String userId, String Password);
	
	@Query(value="select * from customer where first_name like ?1%",nativeQuery = true)
	List<Customer> findUserByFirstName(String firstName);
	
	@Query(value="select * from customer where first_name like ?1% and manager_id = ?2",nativeQuery = true)
	List<Customer> findUserByFirstNameAndManagerId(String firstName, int managerId);
	
	@Query(value="select customer_id from customer where manager_id = ?1",nativeQuery = true)
	List<Integer> getcustomerlistformanagerId(int managerId);
	
	@Query(value="select * from customer where customer_id not in :customeridlist",nativeQuery = true)
	List<Customer> findnonmanagedcustomerlist(List<Integer> customeridlist);
}
