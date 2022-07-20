package com.skillstorm.demo2;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.skillstorm.MainApplication;
import com.skillstorm.SpringBeanConfiguration;

@Configuration
//@Import(SpringBeanConfiguration.class) // This adds the other ConfigurationFile to our context
// This is done by Spring Boot automatically
// If I wanted multiple configuration files
@ComponentScan("com.skillstorm.demo2") // Scans our classpath for any classes annotated with @Component
//@PropertySource("classpath:taco.properties") // Auto loads this into the environment
@PropertySources({
	@PropertySource("classpath:taco.properties"),
	@PropertySource("classpath:db/db-${spring.profiles.active}.properties")
	// java -jar -Dspring.profile.active=prod myJar.jar
})
public class AppConfig {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(context.getBean(Taco.class));
//		System.out.println(context.getBean("nunchuck")); // I get nunchuck from the other file
		Environment env = context.getBean(Environment.class);
		System.out.println(env);
		System.out.println(env.getProperty("taco.protein"));
		
		Taco taco = (Taco) context.getBean("taco");
		System.out.println(taco);
	}
	
	// This works fine
//	@Bean
//	public Taco taco() {
//		return new Taco();
//	}
}

//@Service
//class DbConnectionManager implements InitializingBean {
//	
//	@Value("${db.url}")
//	private String url;
//	
//	@Value("${db.username}")
//	private String username;
//	
//	@Value("${db.password}")
//	private String password;
//
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("URL: " + url);
//		System.out.println("Username: " + username);
//		System.out.println("Password: " + password);
//	}
//}
