package com.mercadolibre.solarsystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.mercadolibre.solarsystem.model.Planet;
import com.mercadolibre.solarsystem.model.Weather;
import com.mercadolibre.solarsystem.repository.WeatherRepository;
import com.mercadolibre.solarsystem.service.WeatherService;
import com.mercadolibre.solarsystem.utils.MathUtil;

@Service
public class WeatherServiceImpl implements WeatherService{
	
	@Autowired
	protected WeatherRepository weatherRepository;

	@Override
	public List<Weather> findAll() {
		return Lists.newArrayList(weatherRepository.findAll());
	}

	@Override
	public Optional<Weather> findById(Integer id) {
		return weatherRepository.findById(id);
	}

	@Override
	public Boolean isDrought(Integer day, List<Planet> planets) {
		Boolean condition = false;
		if(planets.size() == 3) {
			
			Boolean isDroughtPlanets= false;
			isDroughtPlanets = MathUtil.areDotsAlligned(planets.get(0).calculateXPosition(day), planets.get(0).calculateYPosition(day), 
					planets.get(1).calculateXPosition(day), planets.get(1).calculateYPosition(day), 
					planets.get(2).calculateXPosition(day), planets.get(2).calculateYPosition(day));
			
			Boolean isDroughtSun= false;
			isDroughtSun = MathUtil.areDotsAlligned(planets.get(0).calculateXPosition(day), planets.get(0).calculateYPosition(day), 
					planets.get(1).calculateXPosition(day), planets.get(1).calculateYPosition(day), 0D, 0D); //sunPosition
			
			condition =  (isDroughtPlanets.equals(isDroughtSun) && isDroughtPlanets.equals(true));
		}
		return condition;
	}

	@Override
	public Boolean isRainfall(Integer day, List<Planet> planets) {
		Boolean condition = false;
		if(planets.size() == 3) {
			Double triangleArea = MathUtil.area(planets.get(0).calculateXPosition(day), planets.get(0).calculateYPosition(day), 
					planets.get(1).calculateXPosition(day), planets.get(1).calculateYPosition(day), 
					planets.get(2).calculateXPosition(day), planets.get(2).calculateYPosition(day)); 
			
			Double triangleAreaSunWithPlanet2AndPlanet3 = MathUtil.area(0D, 0D, 
					planets.get(1).calculateXPosition(day), planets.get(1).calculateYPosition(day), 
					planets.get(2).calculateXPosition(day), planets.get(2).calculateYPosition(day));
			
			Double triangleAreaSunWithPlanet1AndPlanet3 = MathUtil.area(planets.get(0).calculateXPosition(day), planets.get(0).calculateYPosition(day), 
					0D, 0D,	planets.get(2).calculateXPosition(day), planets.get(2).calculateYPosition(day));
			
			Double triangleAreaSunWithPlanet1AndPlanet2 = MathUtil.area(planets.get(0).calculateXPosition(day), planets.get(0).calculateYPosition(day), 
					planets.get(1).calculateXPosition(day), planets.get(1).calculateYPosition(day), 0D, 0D);
			
			condition = (triangleArea == triangleAreaSunWithPlanet2AndPlanet3 + triangleAreaSunWithPlanet1AndPlanet3 + triangleAreaSunWithPlanet1AndPlanet2);
		}
		return condition;
	}

	@Override
	public Boolean isOptimalConditions(Integer day, List<Planet> planets) {
		Boolean isDroughtPlanets= false;
		if(planets.size() == 3) {
			isDroughtPlanets = MathUtil.areDotsAlligned(planets.get(0).calculateXPosition(day), planets.get(0).calculateYPosition(day), 
					planets.get(1).calculateXPosition(day), planets.get(1).calculateYPosition(day), 
					planets.get(2).calculateXPosition(day), planets.get(2).calculateYPosition(day));
		}
		return isDroughtPlanets;
	}

}
