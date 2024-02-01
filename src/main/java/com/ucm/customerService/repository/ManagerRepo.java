package com.ucm.customerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucm.customerService.model.entity.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Integer> {
	
	Manager findByUserIdAndPassword(String userId, String Password);

}
