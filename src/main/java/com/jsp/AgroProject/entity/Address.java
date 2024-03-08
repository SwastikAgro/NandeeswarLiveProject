package com.jsp.AgroProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data 
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	String houseNo;
	String street;
	String landMark;
	String mandal;
	String district;
	String state;
	int pincode;

	
}
