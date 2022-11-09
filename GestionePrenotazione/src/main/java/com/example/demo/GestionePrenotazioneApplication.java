package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "runnable")
public class GestionePrenotazioneApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionePrenotazioneApplication.class, args);
	}

}
