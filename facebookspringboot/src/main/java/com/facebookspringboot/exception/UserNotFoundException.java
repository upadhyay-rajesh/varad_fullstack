package com.facebookspringboot.exception;

import com.facebookspringboot.entity.FacebookUser;

public class UserNotFoundException extends Exception {
	private String message;
	public UserNotFoundException(String string) {
		this.message=string;
	}
	
	public String toString() {
		return this.message;
	}

}
