package com.skillstorm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ParkApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkApiApplication.class, args);
	}

}
