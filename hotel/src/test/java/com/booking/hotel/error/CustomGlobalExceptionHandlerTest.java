package com.booking.hotel.error;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CustomGlobalExceptionHandlerTest {

	@InjectMocks
	CustomGlobalExceptionHandler customGlobalExceptionHandler;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testErrorHandler() {
		customGlobalExceptionHandler.errorHandler(new UsernameAlreadyExists("username already exists"));
	}

	@Test
	public void testerrorHandlerPassword() {
		customGlobalExceptionHandler.errorHandlerPassword(new PasswordConstraintException("password constraint exception"));
	}

	@Test
	public void testerrorHandlerNoUser() {
		customGlobalExceptionHandler.errorHandlerNoUser(new UserNotFoundException("user not found"));
	}
}
