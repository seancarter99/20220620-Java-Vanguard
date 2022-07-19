package com.skillstorm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.skillstorm.beans.Human;
import com.skillstorm.beans.Pistol;
import com.skillstorm.beans.Robot;
import com.skillstorm.beans.Sword;
import com.skillstorm.beans.Weapon;

// Functions the same as an XML config, only difference is I can write logic
@Configuration
public class SpringBeanConfiguration {

	/**
	 * Bean scopes:
	 * 
	 * Singleton (Only one copy of this bean is made) (Stateless)
	 * Prototype (Bean is lazily intialized as needed. Multiple created) (Stateful)
	 * 
	 * Web Application only:
	 * Request (Bean stays alive for the duration of an HTTP request. Specifically,
	 *          the duration of the HttpServletRequest object)
	 * Session (Bean stays alive for the duration of a user session (Until they logout/timeout))
	 */
	
	// Define methods annotated with @Bean that return the beans that I want
	
	// @Bean indicates to Spring that this is a bean for it to manage
	@Bean // By default the bean name is the method name
	@Primary
	public Weapon weapon() {
		return new Sword();
	}
	
	// This overrides the bean name to be "pistol"
	@Bean(name = "pistol")
	@Scope("prototype")
	public Pistol handgun() {
		return new Pistol();
	}
	
	@Bean
	public Sword sword() {
		return new Sword();
	}
	
	@Bean
	@Primary
	public Human cowboy() {
		// 1. Create a Human object
		// 2. Use the setter to set the primaryWeapon to be a Pistol
		// 3. Return the Human object
		Human cowboy = new Human();
		cowboy.setPrimaryWeapon(handgun()); // Setter injection
		return cowboy;
	}
	
	@Bean
	public Human knight() {
		return new Human(sword()); // Constructor injection
	}
	
	@Bean
	public Robot robot() {
		return new Robot();
	}
}
