package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	//handling a specific exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundExHandling(ResourceNotFoundException exception,
			WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails();
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
}
