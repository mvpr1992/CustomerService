package com.ucm.customerService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ucm.customerService.model.entity.UserSignup;

public interface UserSignUpRepo extends JpaRepository<UserSignup, Integer> {
	
	public List<UserSignup> findByStatus(String status);

}
