package com.mercadolibre.solarsystem.exception;

public class WeatherFormatException extends ApiException{

	private static final long serialVersionUID = 4018175997670604003L;

	public WeatherFormatException(){
		super("ERROR EN FORMATO DE ENTRADA", null);
	}

}
