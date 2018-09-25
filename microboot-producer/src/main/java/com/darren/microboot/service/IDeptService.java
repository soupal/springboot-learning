package com.darren.microboot.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.darren.microboot.pojo.Dept;

public interface IDeptService {
 
	 public Dept getDept(int deptid);
	
	 @Transactional(readOnly=true)
	 public List<Dept> list();
	 
	 @Transactional(propagation=Propagation.REQUIRED)
	 public boolean add(Dept vo);
}
