
package com.jsp.AgroProject.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
//	@Lob
//	@Column(columnDefinition = "LONGLOB", length = 1000000000)
//	private byte[] pic;
	
}
