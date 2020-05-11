package com.cts.exception;


@SuppressWarnings("serial")
public class IdException extends RuntimeException{
	
	String message;
	
	

	

	public IdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
