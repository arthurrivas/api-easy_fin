package br.com.easyfinapi.services.exceptions;

public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(String msg) {
		super(msg);
	}
	
	public UserNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}