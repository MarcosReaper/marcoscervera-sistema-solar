package com.mercadolibre.solarsystem.service;

import com.mercadolibre.solarsystem.dto.WeatherPlanetResponseDTO;
import com.mercadolibre.solarsystem.model.WeatherPlanet;

public interface WeatherPlanetService {
	
	WeatherPlanetResponseDTO getWeatherByDayAndPlanetName(Integer day, String planet);
	WeatherPlanet save(WeatherPlanet weather);
	Iterable<WeatherPlanet> saveAll(Iterable<WeatherPlanet> weatherPlanets);
	Long countByWeatherId(Integer id); 
}
