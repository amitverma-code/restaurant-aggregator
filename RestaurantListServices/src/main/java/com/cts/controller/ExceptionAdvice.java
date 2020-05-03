package com.cts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cts.exception.RestaurantException;
import com.cts.model.RestaurantError;


@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(RestaurantException.class)
	public ResponseEntity<RestaurantError> mapException(RestaurantException ex) {
		RestaurantError error = new RestaurantError();
		return new ResponseEntity<RestaurantError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
