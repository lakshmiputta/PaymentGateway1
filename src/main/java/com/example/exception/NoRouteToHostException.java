package com.example.exception;

public class NoRouteToHostException extends RuntimeException  {
public NoRouteToHostException(String message) {
	super(message);
}

}
