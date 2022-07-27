package com.skillstorm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication is a convenience annotation and is @Configuration, @EnableAutoConfiguration,
 *  and @ComponentScan all in one
 *  
 *  @EnableAutoConfiguration - Spring will look at the classpath to determine what you need configured
 *
 * Since Spring Web is in the classpath @EnableWebMvc is auto added and the DispatcherServlet is created
 *  on our behalf
 */
@SpringBootApplication
public class SpringBootWebzApplication {
	
	// Entry point of the application
	public static void main(String[] args) {
		// Automatically spins up the Application Context
		SpringApplication.run(SpringBootWebzApplication.class, args);
	}

}

// Unnecessary. Auto Configuration by Spring Boot does this for me. I just add the values to application.properties
//@Configuration
//@PropertySource("classpath:application.properties")
//class Datasource {
//	
//	@Value("${db.url}")
//	private String url;
//	
//	@Value("${db.username}")
//	private String username;
//	private String password;
//}
