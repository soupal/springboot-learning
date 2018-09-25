package com.darren.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.darren.microboot.pojo.Dept;

@Mapper
public interface IDeptDAO {

	  public List<Dept> findAll();
	  
	  public boolean doCreate(Dept vo);
}
