package com.darren.microboot.service;

import java.util.Map;
import java.util.Set;

import com.darren.microboot.pojo.Member;

public interface IMemberServcie {

	  public Member get(String mid);
	  
	  public Map<String, Set<String>> listAuthByMember(String mid); 
}
