package com.darren.microboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.darren.microboot.dao.IDeptDAO;
import com.darren.microboot.pojo.Dept;
import com.darren.microboot.service.IDeptService;

public class DeptServiceImpl implements IDeptService {

	@Resource
	private IDeptDAO deptDao;
	
	@Override
	public Dept getDept(int deptid) {
		Dept dept = new Dept();
		dept.setDeptno(deptid);
		dept.setDname("行政部");
		dept.setLoc("上海");
		return dept;
	}

	@Override
	public List<Dept> list() {
		return deptDao.findAll();
	}

	@Override
	public boolean add(Dept vo) {
		return deptDao.doCreate(vo);
	}


	
	

}
