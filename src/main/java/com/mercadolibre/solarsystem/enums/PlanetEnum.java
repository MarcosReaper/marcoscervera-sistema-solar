package com.mercadolibre.solarsystem.enums;

public enum PlanetEnum {
	
	FERENGI(1,"Ferengi"),
	BETASOIDE(2,"Betasoide"),
	VULCANO(3,"Vulcano");
	
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	private PlanetEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
