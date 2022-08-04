package com.skillstorm.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.demo.models.Pokemon;

@Service
public class MessagePublishingService {

	private static final Logger logger = LoggerFactory.getLogger(MessagePublishingService.class);
	
	@Autowired
	private Queue queue;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendPokemon(Pokemon pokemon) {
		logger.info("Sending pokemon: " + pokemon);
		rabbitTemplate.convertAndSend(queue.getName(), pokemon);
	}
}
