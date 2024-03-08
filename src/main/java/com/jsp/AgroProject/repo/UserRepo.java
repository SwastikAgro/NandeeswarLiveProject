package com.jsp.AgroProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jsp.AgroProject.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	
}
