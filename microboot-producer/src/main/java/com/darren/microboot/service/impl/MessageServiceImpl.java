package com.darren.microboot.service.impl;

import com.darren.microboot.service.IMessageService;

//@Service
public class MessageServiceImpl implements IMessageService {

	@Override
	public String info() {
		return "It is rainning outside!";
	}

}
