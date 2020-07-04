package com.booking.hotel.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomGlobalExceptionHandler {
    
	@ExceptionHandler(UsernameAlreadyExists.class)
    public ResponseEntity<?> errorHandler(UsernameAlreadyExists e) {
    	return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

	@ExceptionHandler(PasswordConstraintException.class)
	public ResponseEntity<?> errorHandlerPassword(PasswordConstraintException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> errorHandlerNoUser(UserNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}