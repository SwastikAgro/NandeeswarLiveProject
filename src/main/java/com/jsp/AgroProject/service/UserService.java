package com.jsp.AgroProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.jsp.AgroProject.dao.UserDao;
import com.jsp.AgroProject.entity.User;
import com.jsp.AgroProject.exception.UserNotFoundException;
import com.jsp.AgroProject.util.ResponseStructure;
@Service
public class UserService {
	
	private static final int ResponseEntity = 0;
	@Autowired
	private UserDao dao;
	@Autowired
	private JavaMailSender mailSender;
//	register
	public ResponseEntity<ResponseStructure<User>> register(User user) {
		
		ResponseStructure<User> m= new ResponseStructure<User>();
		m.setData(dao.saveUser(user));
		m.setMessage("user Registered successfully");
		m.setStatus(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<User>>(m, HttpStatus.CREATED);
		
	}
//	saveUser
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {

		ResponseStructure<User> m= new ResponseStructure<User>();	
		m.setData(dao.saveUser(user));
		m.setMessage("user saved successfully");
		m.setStatus(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<User>> (m, HttpStatus.ACCEPTED);
	}
//	fetchUser
	public ResponseEntity<ResponseStructure<User>> fetchUser(int id) {
		ResponseStructure<User>m= new ResponseStructure<User>();
		
		m.setData(dao.fetchUser(id));
		m.setMessage(" user fetched successfully");
		m.setStatus(HttpStatus.FOUND.value());
		
		return new ResponseEntity<ResponseStructure<User>> (m, HttpStatus.FOUND);
	}
//	deleteUser
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		 User db = dao.deleteUser(id);
		if(db!=null) {
			ResponseStructure<User> m=new ResponseStructure<User>();
			m.setData(db);
			m.setMessage("user deleted successfully ");
			m.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>> (m, HttpStatus.FOUND);
			
		}else {
			 throw new UserNotFoundException("no user found by this  id"+id);
		}
	}
//	fetchAll
	public List<User> fetchAll() {

		return dao.fetchAll();
	}
//	updateUser
	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		User db = dao.fetchUser(user.getId());
		if(db!=null) {
			ResponseStructure<User>m=new ResponseStructure<User>();
			m.setData(dao.updateUser(user));
			m.setMessage("user updated successfully");
			m.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(m,HttpStatus.FOUND);
		}else {
			throw new UserNotFoundException("no user found"+user.getId());
		}
		 
	}
	

}
