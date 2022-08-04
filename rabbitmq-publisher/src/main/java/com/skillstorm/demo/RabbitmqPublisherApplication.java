package com.skillstorm.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.skillstorm.demo.models.Car;
import com.skillstorm.demo.models.Planet;
import com.skillstorm.demo.services.MessagePublishingService;

@SpringBootApplication
public class RabbitmqPublisherApplication implements CommandLineRunner {

	@Autowired
	private MessagePublishingService service;
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqPublisherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// This is a method that is automatically called by Spring once the bean has been
		// initialized and the ApplicationContext has finished loading
		
		// Gets auto converted to JSON through AOP and Jackson
		service.sendEntirePlanet(new Planet("Gliese 581d", 8_709.3));
		
		service.sendCar(new Car("Ford", "Model-T", 1945));
		service.sendCar(new Car("Toyota", "Camry", 1994));
		service.sendCar(new Car("Smart", "Smart Car", 2012));
	}

}
