package com.jsp.AgroProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.AgroProject.entity.User;
import com.jsp.AgroProject.service.UserService;
import com.jsp.AgroProject.util.ResponseStructure;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<User>> register(@RequestBody User user){
		return service.register(user);
	}
}
