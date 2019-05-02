package com.mercadolibre.solarsystem.repository;

import com.mercadolibre.solarsystem.model.Planet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends CrudRepository <Planet, Integer> {
	
	Planet findByName(String name);
}
