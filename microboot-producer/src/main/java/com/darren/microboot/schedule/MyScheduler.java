package com.darren.microboot.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.darren.microboot.service.IRMMessageProducerService;

@Component
public class MyScheduler {

	@Resource
	private IRMMessageProducerService messageProducer;

	@Scheduled(fixedRate = 10000)
	public void runJobA() {
		messageProducer.sendMessage(new SimpleDateFormat("yyyyMMdd HH:mm:ss.sss").format(new Date()));
	}

	@Scheduled(cron = "* * * * * ?")
	public void runJobB() {
	}

}
