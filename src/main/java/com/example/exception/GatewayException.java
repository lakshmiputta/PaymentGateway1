package com.example.exception;

import java.util.NoSuchElementException;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GatewayException extends ResponseEntityExceptionHandler{
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<Object> handleEmptyInput(EmptyInputException emptyInputException){
		return new ResponseEntity<Object>("Input field is empty", HttpStatus.BAD_REQUEST);
	}
//	@ExceptionHandler(HibernateException.class)
//	public ResponseEntity<Object> hibernateException(HibernateException hibernateException){
//		return new ResponseEntity<Object>("Data Base Connection lost", HttpStatus.BAD_REQUEST);
//	}
	
}