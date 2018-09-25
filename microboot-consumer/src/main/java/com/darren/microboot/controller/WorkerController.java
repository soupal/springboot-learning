package com.darren.microboot.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.darren.microboot.pojo.Worker;

@Controller
@RequestMapping("/worker")
public class WorkerController extends AbstractBaseController {

	@Resource
	private RestTemplate restTemplate;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	@ResponseBody
	public Boolean add(Worker vo) {
		Boolean flag = restTemplate.postForObject("http://localhost:8080/worker/add", vo, Boolean.class);
		return flag;
	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
//	@ResponseBody
	public String get(long mid,Model model) {
		Worker worker = restTemplate.getForObject("http://localhost:8080/worker/get/"+mid, Worker.class);
		model.addAttribute("worker", worker);
		return "worker_show";
	}

}
