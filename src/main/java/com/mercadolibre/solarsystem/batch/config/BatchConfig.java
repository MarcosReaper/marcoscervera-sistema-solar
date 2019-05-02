package com.mercadolibre.solarsystem.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mercadolibre.solarsystem.batch.tasks.AnswersWeatherForecastBatch;
import com.mercadolibre.solarsystem.batch.tasks.GenerateWeatherForecastBatch;
import com.mercadolibre.solarsystem.service.PlanetService;
import com.mercadolibre.solarsystem.service.WeatherPlanetService;
import com.mercadolibre.solarsystem.service.WeatherService;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
    private JobBuilderFactory jobs;
 
    @Autowired
    private StepBuilderFactory steps;
    
    @Autowired
    private PlanetService planetService;
    
    @Autowired
	private WeatherService weatherService;
    
    @Autowired
	private WeatherPlanetService weatherPlanetService;
    
    @Bean
    public Step stepOne(){
        return steps.get("stepOne")
                .tasklet(generateWeatherForecastBatch())
                .build();
    }
    
    @Bean
    public Step stepTwo(){
        return steps.get("stepTwo")
                .tasklet(answersWeatherForecastBatch())
                .build();
    }  

    
    @Bean
    public Job weatherJob(){
        return jobs.get("weatherJob")
                .incrementer(new RunIdIncrementer())
                .start(stepOne())
                .next(stepTwo())
                .build();
    }
    
    @Bean
    public GenerateWeatherForecastBatch generateWeatherForecastBatch(){
        return new GenerateWeatherForecastBatch(planetService, weatherPlanetService, weatherService);
    }
    
    @Bean
    public AnswersWeatherForecastBatch answersWeatherForecastBatch() {
    	return new AnswersWeatherForecastBatch(weatherPlanetService);
    }
}
