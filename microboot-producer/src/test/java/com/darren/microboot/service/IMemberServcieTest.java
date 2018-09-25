package com.darren.microboot.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.darren.microboot.StartSpringBootMain;

@SpringBootTest(classes = StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class IMemberServcieTest {

	@Resource
	private IMemberServcie memberService;
	
	@Test
	public void testGet() {
		System.out.println(memberService.get("admin"));
	}

	@Test
	public void testListAuthByMember() {
		System.out.println(memberService.listAuthByMember("admin"));
	}

}
