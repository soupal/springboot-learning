package com.darren.microboot.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.darren.microboot.StartSpringBootMain;
import com.darren.microboot.pojo.Dept;

@SpringBootTest(classes = StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class DeptControllerTest {

	@Resource
	private DeptController deptController;

	@Test
	public void testGet() {
		Dept dept = deptController.get(124);
		System.out.println(dept);
	}

}
