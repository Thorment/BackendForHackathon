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

		gitKing(dino);


	}

	public static void dance(Item item) {
		System.out.println(item.getName() + " tanzt für dich! yeah!" );
	}
	public static void gitKing(Item item) {
		System.out.println(item.getName() + " Hat git integriert!" );
	}


	public static void typischÄndy(){
		System.out.println("Typisch Ändy VS. Eclipse");
	}
	public static void catchSpannungsabfall(Item item){
		System.out.println(item.getName()+" holt den Spannungsabfalleimer und geht sammeln");
	}
}


