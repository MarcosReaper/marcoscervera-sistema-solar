package com.mercadolibre.solarsystem.enums;

public enum WeatherEnum {
	DROUGHT(1),
	RAINFALL(2),
	OPTIMAL_CONDITIONS(3),
	UNDEFINED(4);
	
	Integer id;

	private WeatherEnum(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
