package com.mercadolibre.solarsystem.batch.tasks;

import org.jboss.logging.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.mercadolibre.solarsystem.enums.WeatherEnum;
import com.mercadolibre.solarsystem.service.WeatherPlanetService;

public class AnswersWeatherForecastBatch implements Tasklet{
	
	private final Logger LOGGER = Logger.getLogger(this.getClass());
	private WeatherPlanetService weatherPlanetService;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		LOGGER.info("Periodos de Sequia: " + weatherPlanetService
				.countByWeatherId(WeatherEnum.DROUGHT.getId()));
		LOGGER.info("Periodos de Lluvia: " + weatherPlanetService
				.countByWeatherId(WeatherEnum.RAINFALL.getId()));
		LOGGER.info("Periodos de Condiciones optimas de presion y temperatura: " +
				weatherPlanetService.countByWeatherId(WeatherEnum.OPTIMAL_CONDITIONS.getId()));
		LOGGER.info("Dia del pico maximo de lluvia: " +
				weatherPlanetService.resolveMaxRainDay());

		return RepeatStatus.FINISHED;
	}

	public AnswersWeatherForecastBatch(WeatherPlanetService weatherPlanetService) {
		super();
		this.weatherPlanetService = weatherPlanetService;
	}
}
