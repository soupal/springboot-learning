package com.darren.microboot.service.impl;

import javax.annotation.Resource;
import javax.jms.Queue;

import org.springframework.jms.core.JmsMessagingTemplate;

import com.darren.microboot.service.IMessageProducerService;

//@Service
public class MessageProducerServiceImpl implements IMessageProducerService {

	@Resource
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Resource
	private Queue queue;
	
	@Override
	public void sendMessage(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
	}

}
