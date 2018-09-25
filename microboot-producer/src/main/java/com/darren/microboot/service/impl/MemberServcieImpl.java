package com.darren.microboot.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.darren.microboot.dao.IActionDAO;
import com.darren.microboot.dao.IMemberDAO;
import com.darren.microboot.dao.IRoleDAO;
import com.darren.microboot.pojo.Member;
import com.darren.microboot.service.IMemberServcie;
@Service
public class MemberServcieImpl implements IMemberServcie {

	@Resource
	private IMemberDAO memberDao;
	@Resource
	private IRoleDAO roleDao;
	@Resource
	private IActionDAO actionDao;

	@Override
	public Member get(String mid) {
		return this.memberDao.findById(mid);
	}

	@Override
	public Map<String, Set<String>> listAuthByMember(String mid) {
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		map.put("allRoles", roleDao.findAllRoleByMember(mid));
		map.put("allActions", actionDao.findAllActionByMember(mid));
		return map;
	}

}
