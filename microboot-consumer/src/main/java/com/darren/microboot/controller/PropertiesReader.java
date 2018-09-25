package com.darren.microboot.controller;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class PropertiesReader {

	// 自动注入此资源对象
	@Resource
	private MessageSource messageSource;
	
	public String message(String key,String...args) {
		return this.messageSource.getMessage(key, args, Locale.getDefault());
	}
}
