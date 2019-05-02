package com.mercadolibre.solarsystem.serviceImpl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.mercadolibre.solarsystem.model.Planet;
import com.mercadolibre.solarsystem.service.PlanetService;
import com.mercadolibre.solarsystem.service.WeatherService;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.mercadolibre.solarsystem.service"})
public class weatherTest {
	
	private Planet vulcano;
	private Planet ferengi;
	private Planet betasoide;
	
	@Autowired
	PlanetService planetService;
	
	@Autowired
	WeatherService weatherService;
	
	@Before
	public void buildPlanets() {
		
		betasoide = buildBetasoidePlanet();
		ferengi = buildFerengiPlanet();
		vulcano = buildVulcanoPlanet();
	}

	@Test
	public void isDrought() {
		Integer day = 90;
		List<Planet> planets = planetService.findAll();
		Assert.assertTrue(weatherService.isDrought(day, planets));
	}
	
	@Test
	public void isRainFall() {
		Integer day = 104;
		List<Planet> planets = planetService.findAll();
		Assert.assertTrue(weatherService.isRainfall(day, planets));
	}
	
	
	private Planet buildBetasoidePlanet() {
		Planet planet = new Planet();
		planet.setId(2);
		planet.setName("Betasoide");
		planet.setClockwise(true);
		planet.setVelocityInDegrees(3);
		planet.setDaysOfTheYear(360/3);
		planet.setDistanceOfTheSun(2000L);
		return planet;
	}

	private Planet buildFerengiPlanet() {
		Planet planet = new Planet();
		planet.setId(1);
		planet.setName("Ferengi");
		planet.setClockwise(true);
		planet.setVelocityInDegrees(1);
		planet.setDaysOfTheYear(360/1);
		planet.setDistanceOfTheSun(500L);
		return planet;
	}

	private Planet buildVulcanoPlanet() {
		
		Planet planet = new Planet();
		planet.setId(3);
		planet.setName("Vulcano");
		planet.setClockwise(false);
		planet.setVelocityInDegrees(5);
		planet.setDaysOfTheYear(360/5);
		planet.setDistanceOfTheSun(1000L);
		return planet;
	}
}
