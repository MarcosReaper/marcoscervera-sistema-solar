package com.mercadolibre.solarsystem.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.mercadolibre.solarsystem.enums.PlanetEnum;

public class WeatherPlanetValidator {
	
	private static Set<String> planetNames = new HashSet<>(Arrays.asList(PlanetEnum.FERENGI.getName(),
			PlanetEnum.BETASOIDE.getName(),PlanetEnum.VULCANO.getName()));
	private static String REGEX_NUMBER = "^[0-9]+$";
	
	public static boolean validateDay(String day) {
		return day != null && day.matches(REGEX_NUMBER);
	}

	public static boolean validatePlanet(String planet) {
		return planet!=null && planetNames.contains(planet);
	}
}
