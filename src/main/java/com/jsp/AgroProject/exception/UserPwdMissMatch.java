package com.jsp.AgroProject.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class UserPwdMissMatch extends RuntimeException{
	public String msg ="user And password missmatch check again";
}
