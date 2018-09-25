package com.darren.microboot.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.darren.microboot.service.IMessageService;

@RestController
public class MessageController extends AbstractBaseController{

	@Resource
	private IMessageService messageService;

	@RequestMapping(value = "/message/info", method = RequestMethod.GET)
	public String info() {
		return messageService.info();
	}

}
