package com.annuaire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.annuaire.controller.PersonController;

@SpringBootApplication
@EnableJpaAuditing

public class AnnuaireApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AnnuaireApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AnnuaireApplication.class, args);
		LOGGER.info("Application started");
	}

}
