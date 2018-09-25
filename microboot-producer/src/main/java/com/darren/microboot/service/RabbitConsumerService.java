package com.darren.microboot.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumerService {

	@RabbitListener(queues = "com.darren.queue")
	public void receiveMessage(String text) {
		System.err.println(
				"\n===============[rabbit mq 接收消息 ]=============\n" + text + "\n========================================\n");
	}

}
