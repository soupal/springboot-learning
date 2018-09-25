package com.darren.microboot.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.darren.microboot.pojo.Dept;
import com.darren.microboot.service.IDeptService;

@RestController
public class DeptController extends AbstractBaseController{

	@Resource
	private IDeptService deptService;

	@RequestMapping(value = "/dept/{deptid}", method = RequestMethod.GET)
	public Dept get(@PathVariable("deptid")  int deptId) {
		
		if(deptId < 0) {
			throw new RuntimeException("deptid can not be negative");
		}
		
		return this.deptService.getDept(deptId);
	}
	
	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public Object list() {
		return this.deptService.list();
	}

}
