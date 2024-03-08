package com.jsp.AgroProject.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PasswordWrongException extends RuntimeException {

	private String msg="Please check the password again";
}
