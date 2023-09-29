package com.example.exception;

public class EmptyInputException extends RuntimeException{
	public EmptyInputException(String httpMessage){
		super(httpMessage);
		
	}

}
