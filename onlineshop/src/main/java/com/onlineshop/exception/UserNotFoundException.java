package com.onlineshop.exception;

public class UserNotFoundException extends Exception {
	private String uu;

	public UserNotFoundException(String uu) {
		super(uu);
		this.uu = uu;
	}

	public String toString() {
		return "User with id " + uu + " not found in database";
	}
}
