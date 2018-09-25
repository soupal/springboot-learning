package com.darren.microboot.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.darren.microboot.StartSpringBootMain;
import com.darren.microboot.pojo.Worker;

@SpringBootTest(classes = StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestRedis {

	@Resource
	private RedisTemplate<String, String> redisTemplate;
	
	@Resource(name="redisTwo")
	private RedisTemplate<String, Object> redisObjectTemplate;
	
	@Test
	public void testSet() {
		redisTemplate.opsForValue().set("mldn", "java");
		System.out.println(redisTemplate.opsForValue().get("mldn"));
	}
	
	@Test
	public void testObjectSet() {
		Worker member = new Worker();
		member.setMid(120L);
		member.setName("无可奉告");
		member.setSalary(10000.00);
		member.setAge(19);
		try {
			member.setBirthday(new SimpleDateFormat("yyyyMMdd").parse("19991225"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		redisObjectTemplate.opsForValue().set("member-05", member);
		System.out.println(member);
		System.out.println(redisObjectTemplate.opsForValue().get("member-01"));
		System.out.println(redisObjectTemplate.opsForValue().get("member-02"));
		System.out.println(redisObjectTemplate.opsForValue().get("member-03"));
		System.out.println(redisObjectTemplate.opsForValue().get("member-04"));
		System.out.println(redisObjectTemplate.opsForValue().get("member-05"));
	}
}
