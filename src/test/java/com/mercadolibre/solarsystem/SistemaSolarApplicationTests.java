package com.mercadolibre.solarsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
@EntityScan({"com.mercadolibre.solarsystem.model"})
@EnableJpaRepositories(basePackages="com.mercadolibre.solarsystem.repository") 

public class SistemaSolarApplicationTests {

	@Test
	public void contextLoads() {
	}

}
