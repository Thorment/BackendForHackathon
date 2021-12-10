package com.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		Item jan = new Item("Jan");
		Item dino = new Item("Dino");
		Item kristin = new Item("Kristin");
		Item andy = new Item("Andy");
		Item geralt = new Item("Geralt");

		System.out.println("Ahh der Strom läuft weg!");
		gitgud(dino);
		gitgud(kristin);


	}

	public static void dance(Item item) {
		System.out.println(item.getName() + " tanzt für dich! yeah!" );
	}
	public static void gitgud(Item item) {
		System.out.println(item.getName() + " Hat git integriert und ist jetzt voll im Projekt!" );


	}
	public static void typischAndy(){
		System.out.println("Typisch Andy VS. Eclipse");
	}
	public static void catchSpannungsabfall(Item item){
		System.out.println(item.getName()+" holt den Spannungsabfalleimer und geht sammeln");
	}
}


