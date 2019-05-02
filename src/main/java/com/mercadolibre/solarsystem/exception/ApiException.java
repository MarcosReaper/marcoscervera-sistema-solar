package com.mercadolibre.solarsystem.exception;

public class ApiException extends Exception{
	
	private static final long serialVersionUID = 1104306672939965560L;
	
	private final String description;

	public ApiException(String description, Throwable cause){
		this.description = description;
	}
	
	public ApiException(Throwable cause) {
		super(cause);
		this.description = cause.getMessage();
	}

	public String getDescription() {
		return description;
	}
	

}
