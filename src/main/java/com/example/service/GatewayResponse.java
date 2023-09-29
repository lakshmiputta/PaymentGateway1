package com.example.service;

import org.springframework.http.HttpStatus;

public class GatewayResponse{
	private String httpMessage;
	private HttpStatus httpStatus;
	public String getHttpMessage() {
		return httpMessage;
	}
	public void setHttpMessage(String httpMessage) {
		this.httpMessage = httpMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public GatewayResponse(String httpMessage, HttpStatus httpStatus) {
		super();
		this.httpMessage = httpMessage;
	
		this.httpStatus = httpStatus;
	}
	

}
