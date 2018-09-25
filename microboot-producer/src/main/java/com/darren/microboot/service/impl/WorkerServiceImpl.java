package com.darren.microboot.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.darren.microboot.pojo.Worker;
import com.darren.microboot.service.IWorkerService;

@Service
public class WorkerServiceImpl implements IWorkerService {

	@Override
	public Worker get(long mid) {
		Worker vo =  new Worker();
		vo.setMid(mid);
		vo.setName("KING");
		vo.setSalary(5000.00);
		vo.setAge(18);
		vo.setBirthday(new Date());
		return vo;
	}

}
