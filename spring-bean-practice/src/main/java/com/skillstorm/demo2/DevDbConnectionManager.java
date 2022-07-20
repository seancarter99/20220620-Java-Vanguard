package com.skillstorm.demo2;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!prod")
//@Profile("dev | qa") // Make if profile is either dev or qa
//@Profile("prod & admin") // Make if profile is both dev AND admin
public class DevDbConnectionManager implements InitializingBean {
	
	@Value("${db.url}")
	private String url;
	
	@Value("${db.username}")
	private String username;
	
	@Value("${db.password}")
	private String password;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("URL: " + url);
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
	}
}
