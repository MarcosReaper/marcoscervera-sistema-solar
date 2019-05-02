package com.mercadolibre.solarsystem.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@ControllerAdvice
public class ExceptionHandlerController {

	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);
	
	@ExceptionHandler(value = Exception.class)
	protected ResponseEntity<String> handleException(Exception ex, HttpServletRequest request) {
		logger.error("Exception Handler - "+ ex.getMessage(), ex);
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = WeatherFormatException.class)
	protected ResponseEntity<String> handleGeneralError(WeatherFormatException ex, HttpServletRequest request) {
		logger.warn("Exception Handler - WeatherFormatException: "+ ex.getMessage());
		return new ResponseEntity<>(ex.getDescription(), HttpStatus.BAD_REQUEST);
	}
	
}
