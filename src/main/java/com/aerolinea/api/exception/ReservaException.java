package com.aerolinea.api.exception;

public class ReservaException extends Exception {

	private static final long serialVersionUID = 1L;

	public ReservaException(){
		super();
	}
	
	public ReservaException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ReservaException(String message) {
		super(message);
    }
	
	public ReservaException(Throwable cause) {
		super(cause);
	}

}
