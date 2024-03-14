package com.jsp.AgroProject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.AgroProject.entity.User;
import com.jsp.AgroProject.repo.UserRepo;
@Repository
public class UserDao {
	
	@Autowired
	private UserRepo repo;
	
//save
	public User saveUser(User details) {
		return repo.save(details);
	}
//fetchuser
	public User fetchUser(int id) {
		Optional<User> db = repo.findById(id);
		if(db.isPresent()) {
			return db.get();
		}
		else
			return null;
	}
//delete
	public User deleteUser(int id) {
		Optional<User> db = repo.findById(id);
		if(db.isPresent()) {
			repo.deleteById(id);
			return db.get();
		}
		else
		return null;
	}
//fetchall
	public List<User> fetchAll() {
		return repo.findAll();
	}
	
	
//updateUser
	public User updateUser(User user) {
		Optional<User> db = repo.findById(user.getId());
		User m = db.get();
		if(db.isPresent()) {
			if(user.getFirstName()==null) {
				user.setFirstName(m.getFirstName());
			}
			if(user.getLastName()==null) {
				user.setLastName(m.getLastName());
			}
			if(user.getPhone()==0) {
				user.setPhone(m.getPhone());
			}
			if(user.getEmail()==null) {
				user.setEmail(m.getEmail());
			}
			if(user.getPwd()==null) {
				user.setPwd(m.getPwd());
			}
			if(user.getGender()==null) {
				user.setGender(m.getGender());
			}
			if(user.getAge()==0) {
				user.setGender(m.getGender());
			}
			if(user.getAddress()==null) {
				user.setAddress(m.getAddress());
			}
			if(user.getFirstName()==null) {
				user.setFirstName(m.getFirstName());
			}
			return repo.save(user);
		}else
		return null;
	}
	
	
	

	
}
