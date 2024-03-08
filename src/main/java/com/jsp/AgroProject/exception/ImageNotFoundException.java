package com.jsp.AgroProject.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ImageNotFoundException  extends RuntimeException{

	private String msg="image not found";	
}
