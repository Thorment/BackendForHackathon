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
		Item ändy = new Item("Ändy");
		Item gäralt = new Item("Gäralt");

		if (dino.getName().equals( "Dino" )) {
			System.out.println("guck mal wie er tanzt");
		}
		catchSpannungsabfall(gäralt);
		dance(jan);
		dance(dino);
		dance(kristin);
		dance(ändy);

		//TODO teständerung
		typischÄndy();

		System.out.println("Ahh der Strom läuft weg!");


	}

	public static void dance(Item item) {
		System.out.println(item.getName() + " tanzt für dich! yeah!" );
	}


	public static void typischÄndy(){
		System.out.println("Typisch Ändy VS. Eclipse");
	}
	public static void catchSpannungsabfall(Item item){
		System.out.println(item.getName()+" holt den Spannungsabfalleimer und geht sammeln");
	}
}


