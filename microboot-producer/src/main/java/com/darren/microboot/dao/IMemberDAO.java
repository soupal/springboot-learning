package com.darren.microboot.dao;

import org.apache.ibatis.annotations.Mapper;

import com.darren.microboot.pojo.Member;

@Mapper
public interface IMemberDAO {

	public Member findById(String mid);

}
