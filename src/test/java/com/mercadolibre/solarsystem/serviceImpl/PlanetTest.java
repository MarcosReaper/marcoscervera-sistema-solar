package com.mercadolibre.solarsystem.serviceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.mercadolibre.solarsystem.model.Planet;


@RunWith(SpringRunner.class)
public class PlanetTest {
	
	private Planet vulcano;
	
	
	@Before
	public void buildPlanets() {
		vulcano = buildVulcanoPlanet();
	}
	
	@Test
	public void calculateYPosition() {
		Integer days = 0;
		Double yPosition = vulcano.calculateYPosition(days);
		Assert.assertTrue(yPosition.equals(new BigDecimal(vulcano.getDistanceOfTheSun() * Math.sin(0)).setScale(2, RoundingMode.HALF_EVEN).doubleValue()));
	}
	
	@Test
	public void calculateXPosition() {
		Integer days = 10;
		Double xPosition = vulcano.calculateXPosition(days);
		Assert.assertTrue(xPosition.equals(new BigDecimal(vulcano.getDistanceOfTheSun() * Math.cos(310)).setScale(2, RoundingMode.HALF_EVEN).doubleValue()));
	}
	
	@Test
	public void calculateDaysOfTheYear() {
		Integer days = 1000;
		Integer daysOfTheYear = vulcano.getDayOfTheYear(days);
		Assert.assertTrue(daysOfTheYear.equals(64));
	}
	
	@Test
	public void calculateDegreesOfPosition() {
		Integer days = 1000;
		Double degrees = vulcano.calculateDegressOfPosition(days);
		Assert.assertTrue(degrees.equals(360 - (vulcano.getDayOfTheYear(days) * vulcano.getVelocityInDegrees())));
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
