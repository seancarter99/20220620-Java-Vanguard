package com.skillstorm.demo.services;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.skillstorm.demo.models.Car;
import com.skillstorm.demo.models.Planet;

@Service
public class MessagePublishingService {

//	@Autowired
//	private RestTemplate restTemplate; // You can use this to send off HTTP requests
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Queue directQueue;
	
	@Autowired
	private Exchange fanout;
	
	public void sendEntirePlanet(Planet planet) {
		//                            Queue name,  Message to send
		rabbitTemplate.convertAndSend(directQueue.getName(), planet);
	}
	
	public void sendCar(Car car) {
		rabbitTemplate.convertAndSend(fanout.getName(), car);
	}
	
	// How to use RestTemplate
//	public void main(String[] args) throws RestClientException, URISyntaxException {
//		ResponseEntity<String> resp = restTemplate.getForEntity(new URI(""), String.class);
//	}
}
