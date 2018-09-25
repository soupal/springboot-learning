package com.darren.microboot.service;

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
public class IDeptServiceTest {

	@Resource
	private IDeptService deptService;
	
	@Test
	public void testGetDept() {
		deptService.getDept(10);
	}

	@Test
	public void testList() {
		System.out.println(deptService.list()); 
	}
	
	@Test
	public void testAdd() {
		Dept dept = new Dept();
		dept.setDeptno(50);
		dept.setDname("行政部");
		dept.setLoc("北京");
		System.out.println(deptService.add(dept));
	}

}
