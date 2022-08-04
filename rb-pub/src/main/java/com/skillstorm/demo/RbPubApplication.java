package com.skillstorm.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.skillstorm.demo.models.Pokemon;
import com.skillstorm.demo.services.MessagePublishingService;

@SpringBootApplication
public class RbPubApplication implements CommandLineRunner {

	@Autowired
	private MessagePublishingService service;
	
	public static void main(String[] args) {
		SpringApplication.run(RbPubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.sendPokemon(new Pokemon("Charizard", "Fire"));
	}

}
