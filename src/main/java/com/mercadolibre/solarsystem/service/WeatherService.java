package com.mercadolibre.solarsystem.service;

import java.util.List;
import java.util.Optional;

import com.mercadolibre.solarsystem.model.Planet;
import com.mercadolibre.solarsystem.model.Weather;

public interface WeatherService {
	
	List<Weather> findAll();
	Optional<Weather> findById(Integer id);
	Boolean isDrought(Integer day, List<Planet> planets);
	Boolean isRainfall(Integer day, List<Planet> planets);
	Boolean isOptimalConditions(Integer day, List<Planet> planets);
}
