package com.jsp.AgroProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
	private String receipient;
	private String msgBody;
	private String subject;
	private String attachment;
	
	
}
