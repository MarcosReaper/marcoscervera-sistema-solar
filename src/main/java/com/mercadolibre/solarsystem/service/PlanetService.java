package com.mercadolibre.solarsystem.service;

import java.util.List;
import java.util.Optional;

import com.mercadolibre.solarsystem.model.Planet;

public interface PlanetService {
	
	List<Planet> findAll();
	Planet findByName(String name);
	Optional<Planet> findById(Integer id);
}
