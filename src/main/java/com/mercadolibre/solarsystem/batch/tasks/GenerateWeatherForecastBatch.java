package com.mercadolibre.solarsystem.batch.tasks;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.mercadolibre.solarsystem.enums.WeatherEnum;
import com.mercadolibre.solarsystem.model.Planet;
import com.mercadolibre.solarsystem.model.Weather;
import com.mercadolibre.solarsystem.model.WeatherPlanet;
import com.mercadolibre.solarsystem.service.PlanetService;
import com.mercadolibre.solarsystem.service.WeatherPlanetService;
import com.mercadolibre.solarsystem.service.WeatherService;

public class GenerateWeatherForecastBatch implements Tasklet{
	
	private final Logger LOGGER = Logger.getLogger(this.getClass());
	private PlanetService planetService;
	private WeatherPlanetService weatherPlanetService;
	private WeatherService weatherService;
	
	private Integer daysOfCalculate;
	private List<Planet> planets;
	private List<WeatherPlanet> weatherPlanetList;
	

	public GenerateWeatherForecastBatch(PlanetService planetService, WeatherPlanetService weatherPlanetService, WeatherService weatherService) {
		this.planetService = planetService;
		this.weatherPlanetService = weatherPlanetService;
		this.weatherService = weatherService;
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		init();
		for(Integer i=0;i<=daysOfCalculate;i++) {
			LOGGER.info("Dia: " + i);
			weatherPlanetList.addAll(generateWeatherPlanet(i));
		}
		
		weatherPlanetService.saveAll(weatherPlanetList);
		
		return RepeatStatus.FINISHED;
	}
	
	public void init() {
		
		planets = planetService.findAll();
		daysOfCalculate = 12000;
		weatherPlanetList = new ArrayList<>();
	}
	
	private List<WeatherPlanet> generateWeatherPlanet(Integer day) {
		Integer auxDay = new Integer(day);
		List<WeatherPlanet> weatherPlanetList = new ArrayList<>();
		
		Weather weather = calculateWeather(auxDay,planets);
		
		planets.stream().forEach(planet->{
			
			if(weather!=null) {
				LOGGER.info("- Planeta: " + planet.getName() + " dia: " + auxDay + " dia del anio: " 
						+ planet.getDayOfTheYear(auxDay) + " anio: " + planet.getYear(auxDay) + " Id: " +
						Long.valueOf(planet.getId().toString() + auxDay));
				
				WeatherPlanet weatherPlanet = new WeatherPlanet();
				weatherPlanet.setDay(auxDay);
				weatherPlanet.setWeather(weather);
				weatherPlanet.setPlanet(planet);
				weatherPlanet.setId(Long.valueOf(planet.getId().toString()+ auxDay));
				weatherPlanetList.add(weatherPlanet);
			}
		});
		
		return weatherPlanetList;
	}

	private Weather calculateWeather(Integer day, List<Planet> planets) {
		LOGGER.info("calculando el clima:  ");
		
		Weather weather = null;
		if(weatherService.isDrought(day,planets)) {
			LOGGER.info("    Sequia");
			weather = new Weather(WeatherEnum.DROUGHT.getId());
			
		} else if(weatherService.isRainfall(day, planets)) {
			LOGGER.info("    Lluvia");
			weather = new Weather(WeatherEnum.RAINFALL.getId());
			
		} else if(weatherService.isOptimalConditions(day,planets)) {
			LOGGER.info("    Condiciones Optimas");
			weather = new Weather(WeatherEnum.OPTIMAL_CONDITIONS.getId());
		} else { 
			LOGGER.info("    Indefinido");
			weather = new Weather(WeatherEnum.UNDEFINED.getId());
		}
		
		return weather;
	}

}
