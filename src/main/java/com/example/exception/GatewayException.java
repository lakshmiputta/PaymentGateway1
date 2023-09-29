package com.example.exception;

import java.net.NoRouteToHostException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GatewayException {
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<Object> handleEmptyInput(EmptyInputException emptyInputException){
		return new ResponseEntity<Object>(" Input field is empty", HttpStatus.BAD_REQUEST);
	}
//	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
//	public ResponseEntity<Object> handleEmptyInput(SQLIntegrityConstraintViolationException emptyInputException){
//		return new ResponseEntity<Object>(" httpMessage:merchantId cannot be empty", HttpStatus.BAD_REQUEST);
//	}
//	@ExceptionHandler(HibernateException.class)
//	public ResponseEntity<Object> hibernateException(HibernateException hibernateException){
//		return new ResponseEntity<Object>("Data Base Connection lost", HttpStatus.BAD_REQUEST);
//	}
	@ExceptionHandler(NoRouteToHostException.class)
	public ResponseEntity<Object> noRouteToHostException(NoRouteToHostException noRouteToHostException){
		return new ResponseEntity<Object>("Data Base Connection lost", HttpStatus.BAD_REQUEST);
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
}
