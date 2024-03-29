package com.jsp.AgroProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.AgroProject.entity.User;
import com.jsp.AgroProject.service.UserService;
import com.jsp.AgroProject.util.ResponseStructure;

import jakarta.mail.MessagingException;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<User>> register(@RequestBody User user) throws MessagingException{
		return service.register(user);
	}
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
	@GetMapping("/fetchById")
	public ResponseEntity<ResponseStructure<User>> fetchUser(@RequestParam int id){
		return service.fetchUser(id);
	}
	@GetMapping("/deleteById") 
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int id){
		return service.deleteUser(id);
	}
	@GetMapping("/fetchUsers")
	public List<User> fetchAll(){
		return service.fetchAll();
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user){
		return service.updateUser(user);
	}
	
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<User>> loginUser( String email, String pwd) {
		return service.loginUser(email, pwd);
	}
	@GetMapping("/otp")
	public ResponseEntity<ResponseStructure<Integer>> otpSend(@RequestParam String email) throws MessagingException{
		return service.sendOtp(email);
	}
}
