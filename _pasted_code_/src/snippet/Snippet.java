package snippet;

public class Snippet {
	spring:
	  application:
	    name: spring-cloud-gateway
	  cloud:
	    gateway:
	      routes:
	      - id: park-api
	        # uri: http://localhost:8080 # Without Eureka
	        uri: lb://park-api # Ribbon is the loadbalancer
	        predicates:
	        - Path=/parks/** # Send the request to park-api beginning with a url of /parks
	
	server:
	  port: 8125 # Was the default port by Zuul, this is standard here as well for that reason
	
	eureka:
	  client:
	    service-url:
	      defaultZone: http://localhost:8761/eureka/ # Eureka is resting here
}

