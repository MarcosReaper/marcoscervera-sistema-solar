package com.mercadolibre.solarsystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mercadolibre.solarsystem.model.WeatherPlanet;

@Repository
public interface WeatherPlanetRepository extends CrudRepository <WeatherPlanet, Integer>{
	
	WeatherPlanet findByDayAndPlanet_id(Integer day, Integer id);
	Long countByWeather_id(Integer id);
	List<WeatherPlanet> findByWeather_id(Integer id);
}
