package com.mercadolibre.solarsystem.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mercadolibre.solarsystem.model.Planet;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PlanetRepositoryTest { 
	
	@Autowired
	private PlanetRepository planetRepository;

	@Test
	public void testConnection() {
		Iterable<Planet> planets = planetRepository.findAll();
		assertNotNull(planets);
	}
}
