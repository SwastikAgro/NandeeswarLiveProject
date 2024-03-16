package com.jsp.AgroProject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmailAlreadyExistsException extends RuntimeException {
	private String msg="u r a old user login with old account";

	
}
