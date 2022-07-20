package com.skillstorm.demo2;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod") // This Bean is only created if the profile is "prod"
public class ProdDbConnectionManager implements InitializingBean {

	// Instead of reading the properties file
	// Make a connection to AWS Secrets manager and read from there
	
	@Value("${db.url}")
	private String url;
	
	@Value("${db.username}")
	private String username;
	
	@Value("${db.password}")
	private String password;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.err.println("URL: " + url);
		System.err.println("Username: " + username);
		System.err.println("Password: " + password);
	}
}
