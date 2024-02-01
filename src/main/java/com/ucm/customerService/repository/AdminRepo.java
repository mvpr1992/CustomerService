package com.ucm.customerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucm.customerService.model.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	
	Admin findByUserIdAndPassword(String userId, String Password);

}
