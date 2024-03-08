package com.jsp.AgroProject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.AgroProject.entity.User;
import com.jsp.AgroProject.repo.UserRepo;
@Repository
public class UserDao {
	
	@Autowired
	private UserRepo repo;
	
	
	public User saveUser(User user) {
		
		return repo.save(user);
	}

	
}
