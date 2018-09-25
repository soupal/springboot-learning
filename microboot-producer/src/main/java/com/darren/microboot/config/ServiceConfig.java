package com.darren.microboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.darren.microboot.service.impl.MessageServiceImpl;

@Configuration
public class ServiceConfig {

	@Bean
	public MessageServiceImpl getMessageService() {
		return new MessageServiceImpl();
	}

}
