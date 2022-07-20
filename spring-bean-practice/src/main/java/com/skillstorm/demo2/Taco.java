package com.skillstorm.demo2;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

// I want Taco to be a spring bean
@Component // @Component will be recognized by Spring, and it will make this class into a bean
public class Taco implements BeanNameAware, InitializingBean {

	// Read the taco properties from a taco.properties file
	
	@Autowired
	private Environment env; // Gives me the system environment (including the properties that were loaded)
	
	@Value("Beef") // Assigns protein to be Beef right away
	private String protein;
	
	// Instead of wiring in Environment and setting in InitializingBean, I can do this with @Value
	// ${} is Spring's indicator to read that value from the environment
	@Value("${taco.shell}") // This is known as Spring Expression Language (SpEL)
	private String shell;
	
	
	private double price;
	
	// Read a value from the system environment variables
	@Value("#{systemEnvironment['PROCESSOR_IDENTIFIER']}")
	private String processorIdentifier;
	
	// Don't do this
//	public Taco() {
//		this.protein = env.getProperty("taco.protein");
//	}
	
	@Override
	public void setBeanName(String name) {
		System.out.println(name); // Takes the class name and converts it to camelCase
	}

	@Override
	public void afterPropertiesSet() throws Exception {
//		this.protein = env.getProperty("taco.protein");
//		this.shell = env.getProperty("taco.shell");
		this.price = Double.parseDouble(env.getProperty("taco.price"));
		System.out.println("PROCESSOR_IDENTIFIER: " + processorIdentifier);
	}

	@Override
	public String toString() {
		return "Taco [protein=" + protein + ", shell=" + shell + ", price=" + price + "]";
	}

}


/*
 * Component - Generic component of our application (Like a Div)
 * Service - Same effect as Component, but used to indicate it is a service (business logic)
 * Controller - Functions as the controller in an MVC space (Servlets would be a good controller)
 * Repository - Similar to DAO, but broader and focuses on a "domain"
 */

@Service
class TacoInspector implements BeanNameAware {
	
	// Imagine this class inspects a taco
	
	@Autowired
	private Taco tacoToInspect;

	@Override
	public void setBeanName(String name) {
		System.out.println(name); // Takes the class name and converts it to camelCase
	}
}

@Controller
class TacoServlet implements BeanNameAware {
	@Override
	public void setBeanName(String name) {
		System.out.println(name); // Takes the class name and converts it to camelCase
	}
}

@Repository
class TacoRepository implements BeanNameAware {
	// Fetching taco information from a database
	// Pricing of tacos
	// Nutrition of tacos
	// Taco Promotions
	
	@Override
	public void setBeanName(String name) {
		System.out.println(name); // Takes the class name and converts it to camelCase
	}
}