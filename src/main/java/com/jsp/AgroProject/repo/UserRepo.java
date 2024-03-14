package com.jsp.AgroProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.AgroProject.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	@Query("Select a from User a where a.email=?1")
	User fetchByEmail(String email);

	
}
