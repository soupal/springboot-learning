package com.darren.microboot.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.darren.microboot.pojo.Dept;

@RestController
public class HelloController extends AbstractBaseController{

	@RequestMapping("/")
	public Dept home() {
		Dept dept = new Dept();
		dept.setDeptno(120);
		dept.setDname("急救部门");
		dept.setLoc("上海");
		return dept;
	}

//	@RequestMapping("/echo")
//	public String echo(String msg) {
//		return "[ECHO]" + msg;
//	}
	
	@RequestMapping(value="/echo/{message}",method=RequestMethod.GET)
	public String echo(@PathVariable("message") String msg) {
		return "[ECHO]" + msg;
	}
	
	
	@RequestMapping("/object")
	public List<Object> object(HttpServletRequest request,HttpServletResponse response) {
		List<Object> list = new LinkedList<Object>();
		list.add(request.getRemoteAddr());
		list.add(request.getCharacterEncoding());
		list.add(request.getSession().getId());
		list.add(request.getServletContext().getRealPath("/upload"));
		
		System.out.println(propertiesReader.message("member.add.page"));
		System.out.println(propertiesReader.message("welcome.msg", "您"));
		
		return list;
	}

}
