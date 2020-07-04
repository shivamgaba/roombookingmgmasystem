package com.booking.hotel.error;

public class PasswordConstraintException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3021471950658682554L;

	public PasswordConstraintException(String s) {
		super(s);
	}
}
