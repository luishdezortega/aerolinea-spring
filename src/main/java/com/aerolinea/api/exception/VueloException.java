package com.aerolinea.api.exception;

public class VueloException extends Exception {

	private static final long serialVersionUID = 1L;

	public VueloException(){
		super();
	}
	
	public VueloException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public VueloException(String message) {
		super(message);
    }
	
	public VueloException(Throwable cause) {
		super(cause);
	}

}
