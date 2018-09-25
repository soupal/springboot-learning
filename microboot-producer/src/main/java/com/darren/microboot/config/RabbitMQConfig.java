package com.darren.microboot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	public static final String EXCHANGE = "com.darren.exchange";

	public static final String ROUTINGKEY = "com.darren.routingkey";

	public static final String QUEUE_NAME = "com.darren.queue";

	@Bean
	public Binding bindingExchangeQueue(DirectExchange exchange, Queue queue) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY);
	}

	// 使用直连的模式
	@Bean
	public DirectExchange getDirectExchange() {
		return new DirectExchange(EXCHANGE, true, true);
	}

	// 创建的队列信息
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME);
	}

}
