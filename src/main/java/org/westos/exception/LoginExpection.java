package org.westos.exception;

public class LoginExpection extends Exception{

	private static final long serialVersionUID = 1L;
	
	public String message;
	
	public LoginExpection(String message) {
		super();
		this.message= message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
