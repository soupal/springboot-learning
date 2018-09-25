package com.darren.microboot.service.impl;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.darren.microboot.config.RabbitMQConfig;
import com.darren.microboot.service.IRMMessageProducerService;

@Service
public class RMMessageProducerServiceImpl implements IRMMessageProducerService {

	@Resource
	private RabbitTemplate rabbitTemplate;

	@Override
	public void sendMessage(String msg) {
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTINGKEY, msg);
	}

}
