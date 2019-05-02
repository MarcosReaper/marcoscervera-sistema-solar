package com.mercadolibre.solarsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mercadolibre.solarsystem.model.Weather;

@Repository
public interface WeatherRepository extends CrudRepository <Weather, Integer> {

}
