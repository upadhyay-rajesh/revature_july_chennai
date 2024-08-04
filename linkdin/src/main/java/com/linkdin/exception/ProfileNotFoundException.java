package com.linkdin.exception;

public class ProfileNotFoundException extends Exception{
	String message;
	
	public ProfileNotFoundException(String message){
		this.message=message;
	}
	
	public String toString() {
		return "ha ha ha i am exception "+message;
	}
}
