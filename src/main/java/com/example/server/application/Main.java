package com.example.server.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		SpringApplication.run(Main.class, args);
	}


}


