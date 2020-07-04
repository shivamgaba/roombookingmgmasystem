package com.booking.hotel.error;

public class UsernameAlreadyExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3507138578683736837L;

	public UsernameAlreadyExists(String s) {
		super(s);
	}
}
