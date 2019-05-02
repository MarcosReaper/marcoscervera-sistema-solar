package com.mercadolibre.solarsystem.serviceImpl;

import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.mercadolibre.solarsystem.enums.WeatherEnum;
import com.mercadolibre.solarsystem.service.WeatherPlanetService;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.mercadolibre.solarsystem.service"})
public class AnswersTest {
	private final Logger LOGGER = Logger.getLogger(this.getClass());
	
	@Autowired
	WeatherPlanetService weatherPlanetService;
	
	@Test
	public void answersTest() {
		LOGGER.info("Periodos de Sequia: " + weatherPlanetService
				.countByWeatherId(WeatherEnum.DROUGHT.getId()));
		LOGGER.info("Periodos de Lluvia: " + weatherPlanetService
				.countByWeatherId(WeatherEnum.RAINFALL.getId()));
		LOGGER.info("Periodos de Condiciones optimas de presion y temperatura: " +
				weatherPlanetService.countByWeatherId(WeatherEnum.OPTIMAL_CONDITIONS.getId()));
		LOGGER.info("Dia del pico maximo de lluvia: " +
				weatherPlanetService.resolveMaxRainDay());
	}
}
