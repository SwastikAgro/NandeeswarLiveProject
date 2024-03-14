package com.jsp.AgroProject.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class ExceptionhandlerForUserNotFound extends ResponseEntityExceptionHandler{


//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		List<ObjectError> error = ex.getAllErrors();
//		Map<String, String> map = new HashMap<String, String>();
//		ResponseStructure<Object> structure = new ResponseStructure<>();
//
//		for (ObjectError objectError : error) {
//			String filedName = ((FieldError) objectError).getField();
//			String message = ((FieldError) objectError).getDefaultMessage();
//			map.put(filedName, message);
//
//		}
//		structure.setMessage("provide valid details");
//		structure.setStatus(HttpStatus.NOT_FOUND.value());
//		structure.setData(map);
//
//		return new ResponseEntity<Object>(structure, HttpStatus.BAD_REQUEST);
//	}
//
//	@org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class
//	public ResponseEntity<ResponseStructure<Object>> handleConstraintViolationException(ConstraintViolationException ex) {
//		ResponseStructure<Object> structure = new ResponseStructure();
//		Map<String, String> map = new HashMap<String, String>();
//
//		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
//			String field = violation.getPropertyPath().toString();
//			String message = violation.getMessage();
//			map.put(field, message);
//
//		}
//
//		structure.setMessage("provide proper details");
//		structure.setStatus(HttpStatus.NOT_FOUND.value());
//		structure.setData(map);
//
//		return new ResponseEntity<ResponseStructure<Object>>(structure, HttpStatus.BAD_REQUEST);
//
//	}
}