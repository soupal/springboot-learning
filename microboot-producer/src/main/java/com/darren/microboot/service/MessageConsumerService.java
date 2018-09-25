package com.darren.microboot.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

	// 进行消息接收处理
	@JmsListener(destination = "darren.msg.queue")
	public void receiveMessage(String text) {
		System.out.println("[*****************接收activemq消息]***************" + text);
	}
}
