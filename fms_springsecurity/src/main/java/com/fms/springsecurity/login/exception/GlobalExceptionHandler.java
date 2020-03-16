package com.fms.springsecurity.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	//@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorResponse> handleDataException(ApiException exception) {
	    final ErrorResponse errorResponse = new ErrorResponse(400, exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	//@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorResponse> handleApiException(ApiException exception) {
		final ErrorResponse errorResponse = new ErrorResponse(exception.getCode(), exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getCode()));
	}
}
