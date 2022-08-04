package com.skillstorm.demo.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	// SpEL
	@Value("${queues.direct}") // Pulling from the environment
	private String directQueueName;
	
	@Value("${exchanges.fanout}")
	private String fanoutExchangeName;
	
	@Bean
	public Queue queue() {
		return new Queue(directQueueName);
	}
	
	@Bean
	public Exchange fanout() {
		return new FanoutExchange(fanoutExchangeName);
	}
	
	@Bean
	public MessageConverter jsonMessageConverter() {
		// This bean will be automatically used by RabbitMQ
		// We will use Jackson to convert
		return new Jackson2JsonMessageConverter();
	}
}
