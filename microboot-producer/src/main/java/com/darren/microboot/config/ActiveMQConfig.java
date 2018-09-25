package com.darren.microboot.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;

//@Configuration
//@EnableJms
public class ActiveMQConfig {

//	@Bean
	public Queue queue() {
       return new ActiveMQQueue("darren.msg.queue");
	}
}
