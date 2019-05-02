package com.mercadolibre.solarsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.solarsystem.dto.WeatherPlanetResponseDTO;
import com.mercadolibre.solarsystem.model.Planet;
import com.mercadolibre.solarsystem.model.WeatherPlanet;
import com.mercadolibre.solarsystem.repository.WeatherPlanetRepository;
import com.mercadolibre.solarsystem.service.PlanetService;
import com.mercadolibre.solarsystem.service.WeatherPlanetService;

@Service
public class WeatherPlanetServiceImpl implements WeatherPlanetService{
	
	@Autowired
	WeatherPlanetRepository WeatherPlanetRepository;
	
	@Autowired
	PlanetService planetService;

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

}
