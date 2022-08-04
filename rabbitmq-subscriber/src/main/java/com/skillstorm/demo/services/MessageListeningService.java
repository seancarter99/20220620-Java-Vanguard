package com.skillstorm.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.skillstorm.demo.models.Car;
import com.skillstorm.demo.models.Planet;

@Service
public class MessageListeningService {

	private static final Logger logger = LoggerFactory.getLogger(MessageListeningService.class);
	
	//                    Must be a string
	@RabbitListener(queues = "${queues.direct}")
	public void receiveEntirePlanet(@Payload Planet planet) {
		logger.info("Planet received: " + planet);
	}
	
	@RabbitListener(queues = "${queues.fanout}")
	public void receieveCar(@Payload Car car) {
		logger.info("Car received: " + car);
	}
}
