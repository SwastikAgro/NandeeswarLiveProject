package com.jsp.AgroProject.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmailNotFoundException extends RuntimeException {

	private String msg="Register with us as u are a new user";
}
