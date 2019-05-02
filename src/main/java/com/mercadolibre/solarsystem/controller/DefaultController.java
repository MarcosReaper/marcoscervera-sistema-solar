package com.mercadolibre.solarsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

	@GetMapping(value="/")
	public ResponseEntity<String> defaultPath(){
		return ResponseEntity.ok("URL: localhost:8080/'PLANET_NAME'/weather?day='DAY'  "
				+ " -----  Planets: Ferengi - Betasoide - Vulcano");
	}
}
