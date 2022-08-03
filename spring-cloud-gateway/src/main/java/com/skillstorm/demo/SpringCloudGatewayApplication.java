package com.skillstorm.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableEurekaClient // Registers itself with Eureka
public class SpringCloudGatewayApplication implements InitializingBean {
	
	@Autowired
	private EurekaClient eureka;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayApplication.class, args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// Ribbon instead would determine which instance to use
		// Ribbon is the LB
//		InstanceInfo instance = (InstanceInfo) this.eureka.getInstancesById("park-api").get(0); 
//		String host = instance.getHostName();
//		String ip = instance.getIPAddr();
//		int port = instance.getPort();
		
		// Spring Cloud Gateway and Ribbon then work together to make an HTTP call using those props
	}

}
