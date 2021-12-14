package com.example.server;

import com.example.server.controller.CorsConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * TODO
 * Businesslogik
 * 		- Admin setzt Authorstatus
 * 		- Author setzt Lerninhalte
 * 		- Einpflegen von Testdaten -> Bereiche, Fragen etc
 * 		- Check für Level ob bestanden
 * 		- Check Levelup für User mittels XP sammeln
 */


@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		//CorsConfiguration corsConfiguration = new CorsConfiguration();
		//corsConfiguration.addCorsMappings(CorsRegistry registry);
		SpringApplication.run(Main.class, args);


	}


}


