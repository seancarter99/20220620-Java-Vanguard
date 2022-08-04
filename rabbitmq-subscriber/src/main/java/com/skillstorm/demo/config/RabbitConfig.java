package com.skillstorm.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitConfig {
	
	// SpEL
	@Value("${queues.direct}") // Pulling from the environment
	private String directQueueName;
	
	@Value("${exchanges.fanout}")
	private String fanoutExchangeName;
	
	@Value("${queues.fanout}")
	private String fanoutQueueName;
	
	@Bean
	public Queue queue() {
		return new Queue(directQueueName);
	}
	
	@Bean
	public Exchange fanoutExchange() {
		return new FanoutExchange(fanoutExchangeName);
	}
	
	@Bean
	@Primary
	public Queue fanoutQueue() {
		// Messages from the fanout exchange appear here
		// We need to bind this queue to monitor the exchange
		return new Queue(fanoutQueueName);
	}
	
	@Bean
	public Binding bindQueueToExchange(FanoutExchange exchange, Queue queue) {
		
		// This binds them together until death do them part
		return BindingBuilder.bind(queue).to(exchange);
	}
	
	@Bean
	public MessageConverter jsonMessageConverter() {
		// This bean will be automatically used by RabbitMQ
		// We will use Jackson to convert
		return new Jackson2JsonMessageConverter();
	}
}
