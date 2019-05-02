package com.mercadolibre.solarsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.solarsystem.dto.WeatherPlanetResponseDTO;
import com.mercadolibre.solarsystem.endpoint.SolarSystemEndpoint;
import com.mercadolibre.solarsystem.exception.ApiException;
import com.mercadolibre.solarsystem.exception.WeatherFormatException;
import com.mercadolibre.solarsystem.service.WeatherPlanetService;
import com.mercadolibre.solarsystem.validator.WeatherPlanetValidator;

@RestController
@RequestMapping(SolarSystemEndpoint.BASE)
public class WeatherPlanetController {
	
		@Autowired
		private WeatherPlanetService weatherPlanetService;
		
		@GetMapping(value=SolarSystemEndpoint.GET_WEATHER ,produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<WeatherPlanetResponseDTO> getWeather(@PathVariable String planet, @RequestParam String day) throws ApiException{
			
			if(!WeatherPlanetValidator.validatePlanet(planet) && !WeatherPlanetValidator.validateDay(day)){
				throw new WeatherFormatException();
			}
			
			return ResponseEntity.ok(weatherPlanetService.getWeatherByDayAndPlanetName(Integer.parseInt(day), planet));
		}
		
}
