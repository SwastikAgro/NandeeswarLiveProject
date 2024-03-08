	package com.jsp.AgroProject.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserNotFoundException extends RuntimeException {

	private String msg="u didn't register with us"
			+ "register with us right now for exciting offers";
}
