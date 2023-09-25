package com.example.service;

import org.springframework.http.HttpStatus;

public class GatewayResponse{
	private String httpMessage;
	private int httpCode;
	private HttpStatus httpStatus;
	public String getHttpMessage() {
		return httpMessage;
	}
	public void setHttpMessage(String httpMessage) {
		this.httpMessage = httpMessage;
	}
	public int getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public GatewayResponse(String httpMessage, int httpCode, HttpStatus httpStatus) {
		super();
		this.httpMessage = httpMessage;
		this.httpCode = httpCode;
		this.httpStatus = httpStatus;
	}
	

}
