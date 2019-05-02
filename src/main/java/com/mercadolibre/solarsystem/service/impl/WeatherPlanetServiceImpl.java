package com.mercadolibre.solarsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.solarsystem.dto.WeatherPlanetResponseDTO;
import com.mercadolibre.solarsystem.enums.WeatherEnum;
import com.mercadolibre.solarsystem.model.Planet;
import com.mercadolibre.solarsystem.model.WeatherPlanet;
import com.mercadolibre.solarsystem.repository.WeatherPlanetRepository;
import com.mercadolibre.solarsystem.service.PlanetService;
import com.mercadolibre.solarsystem.service.WeatherPlanetService;
import com.mercadolibre.solarsystem.utils.MathUtil;

@Service
public class WeatherPlanetServiceImpl implements WeatherPlanetService{
	
	@Autowired
	WeatherPlanetRepository WeatherPlanetRepository;
	
	@Autowired
	PlanetService planetService;
	
	private Integer dayMaxRain;
	private Double auxArea;

	@Override
	public WeatherPlanetResponseDTO getWeatherByDayAndPlanetName(Integer day, String planetName) {
		
		WeatherPlanetResponseDTO dto = new WeatherPlanetResponseDTO();
		dto.setDay(day);
		Planet planet = planetService.findByName(planetName);
		WeatherPlanet weatherPlanet = WeatherPlanetRepository.findByDayAndPlanet_id(day, planet.getId());
		if(weatherPlanet!=null) {
			dto.setWeather(weatherPlanet.getWeather().getDescription());
		}
		return dto;
	}

	@Override
	public WeatherPlanet save(WeatherPlanet weatherPlanet) {
		
		return WeatherPlanetRepository.save(weatherPlanet);
	}

	@Override
	public Iterable<WeatherPlanet> saveAll(Iterable<WeatherPlanet> weatherPlanets) {
		
		return WeatherPlanetRepository.saveAll(weatherPlanets);
	}

	@Override
	public Long countByWeatherId(Integer id) {
		return WeatherPlanetRepository.countByWeather_id(id);
	}

	@Override
	public List<WeatherPlanet> findByWeatherId(Integer id) {
		return WeatherPlanetRepository.findByWeather_id(id);
	}

	@Override
	public Integer resolveMaxRainDay() {
		List<Planet> planetList = planetService.findAll();
		List<WeatherPlanet> weatherPlanetList = findByWeatherId(WeatherEnum.RAINFALL.getId());
		auxArea = 0D;
		dayMaxRain = 0;
		if(planetList!=null && planetList.size()== 3) {
			weatherPlanetList.stream().forEach(weatherPlanet ->{
				
				Double area = MathUtil.area(planetList.get(0).calculateXPosition(weatherPlanet.getDay()),
						planetList.get(0).calculateYPosition(weatherPlanet.getDay()),
						planetList.get(1).calculateXPosition(weatherPlanet.getDay()), 
						planetList.get(1).calculateYPosition(weatherPlanet.getDay()), 
						planetList.get(2).calculateXPosition(weatherPlanet.getDay()), 
						planetList.get(2).calculateYPosition(weatherPlanet.getDay()));
				
				if(area > auxArea){
					dayMaxRain = weatherPlanet.getDay();
				}
				
				auxArea = area;
			});
		}
		return dayMaxRain;
	}

}
