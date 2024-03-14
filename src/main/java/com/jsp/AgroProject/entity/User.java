package com.jsp.AgroProject.entity;

import java.util.List;

import com.jsp.AgroProject.enums.UserType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "name cannot be null")
	@NotBlank(message = " name cannot be blank ")
	private String firstName;
	@NotBlank(message = " name cannot be blank ")
	@NotNull(message =" name cannot be null ")
	private String lastName;
	@Column(unique = true)
	private String email;
	private long phone;
	private String  pwd;
	private  String gender;
	private int age;
	@Enumerated(EnumType.STRING)
	private UserType type;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@OneToOne(cascade = CascadeType.ALL)
	private Image image;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Post> post;
	
	
}
