package com.jsp.AgroProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jsp.AgroProject.dao.UserDao;
import com.jsp.AgroProject.entity.User;
import com.jsp.AgroProject.util.ResponseStructure;
@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	@Autowired
	private JavaMailSender mailSender;

	public ResponseEntity<ResponseStructure<User>> register(User user) {
		
		ResponseStructure<User> m= new ResponseStructure<User>();
		m.setData(dao.saveUser(user));
		m.setMessage("user saved successfully");
		m.setStatus(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<User>>(m, HttpStatus.CREATED);
		
	}

}
