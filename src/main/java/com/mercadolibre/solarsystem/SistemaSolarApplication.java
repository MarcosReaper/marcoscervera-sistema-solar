package com.mercadolibre.solarsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.mercadolibre.solarsystem.repository")
public class SistemaSolarApplication{
    
	public static void main(String[] args) {
		SpringApplication.run(SistemaSolarApplication.class, args);
	}

}
