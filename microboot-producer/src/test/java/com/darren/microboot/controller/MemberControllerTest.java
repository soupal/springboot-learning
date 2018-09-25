package com.darren.microboot.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.darren.microboot.StartSpringBootMain;
import com.darren.microboot.pojo.Member;

@SpringBootTest(classes = StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class MemberControllerTest {

	private RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void testGet() {
		String url = "http://localhost:8080/member/get?mid=admin";
		Member member = this.restTemplate.postForObject(url, null, Member.class);
//		Member member = this.restTemplate.getForObject(url,Member.class);
	    System.out.println(member);
	}

	@Test
	public void testAuth() {
		String url = "http://localhost:8080/member/auth?mid=admin";
		Map map = this.restTemplate.postForObject(url, null, Map.class);
		
		System.out.println(map.get("allRoles").getClass());
		System.out.println(map.get("allActions").getClass());
		
//		Set<String> allRoles = new HashSet<String>();
//		Set<String> allActions = new HashSet<String>();
//		allRoles.addAll((List<String>)map.get("allRoles"));
//		allActions.addAll((List<String>)map.get("allActions"));
//		System.out.println(allRoles);
//		System.out.println(allActions);
	}

}
