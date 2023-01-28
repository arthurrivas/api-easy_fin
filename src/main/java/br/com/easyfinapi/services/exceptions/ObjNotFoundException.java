package br.com.easyfinapi.services.exceptions;

public class ObjNotFoundException extends RuntimeException{
	
	public ObjNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
