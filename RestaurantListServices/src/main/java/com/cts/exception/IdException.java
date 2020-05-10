package com.cts.exception;


@SuppressWarnings("serial")
public class IdException extends RuntimeException{
	
	String message;
	
	

	@Override
	public String toString() {
		return " Id not found exception[message=" + message + "]";
	}

	public IdException() {
		super();
	}

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

