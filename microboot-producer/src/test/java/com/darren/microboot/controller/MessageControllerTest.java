package com.darren.microboot.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.darren.microboot.StartSpringBootMain;

@SpringBootTest(classes = StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class MessageControllerTest {

	private Logger logger = LoggerFactory.getLogger("Test");
	
	@Resource
	private MessageController messageController;

	@Test
	public void testInfo() {
		System.out.println(messageController.info());
		logger.info(messageController.info());
	}

}
