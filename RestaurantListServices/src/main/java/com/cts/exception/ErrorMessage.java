package com.cts.exception;
import java.time.LocalDateTime;

public class ErrorMessage {
	
	private String message;
	private int statusCode;
	private LocalDateTime errorTime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public LocalDateTime getErrorTime() {
		return errorTime;
	}
	public void setErrorTime(LocalDateTime l) {
		this.errorTime = l;
	}
	public ErrorMessage(String message, int statusCode, LocalDateTime errorTime) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.errorTime = errorTime;
	}
	public ErrorMessage() {
		super();
	}
	
	

}
