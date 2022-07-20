package com.skillstorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.skillstorm.beans.AlienWerewolf;

public class Day2Main {

	public static void main(String[] args) {
		
		// Initialize the context
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanConfiguration.class);
		
		// Bean is ready for use. Everything has been set/initialized
		AlienWerewolf aw = context.getBean(AlienWerewolf.class);
		aw.act();
		
		// Closing the ApplicationContext will destroy any beans in them
		((AbstractApplicationContext) context).close();
		System.out.println("ApplicationContext closed");
	}

}
