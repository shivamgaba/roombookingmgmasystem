package com.booking.hotel.error;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2113997953414754308L;

	public UserNotFoundException(String s) {
		super(s);
	}
}
