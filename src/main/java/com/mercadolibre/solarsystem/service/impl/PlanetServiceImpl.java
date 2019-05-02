package com.mercadolibre.solarsystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.mercadolibre.solarsystem.model.Planet;
import com.mercadolibre.solarsystem.repository.PlanetRepository;
import com.mercadolibre.solarsystem.service.PlanetService;

@Service
public class PlanetServiceImpl implements PlanetService{
	
	@Autowired
	protected PlanetRepository planetRepository;

	@Override
	public List<Planet> findAll() {
		return Lists.newArrayList(planetRepository.findAll());
	}

	@Override
	public Planet findByName(String name) {
		return planetRepository.findByName(name);
	}

	@Override
	public Optional<Planet> findById(Integer id) {
		return planetRepository.findById(id);
	}

}
