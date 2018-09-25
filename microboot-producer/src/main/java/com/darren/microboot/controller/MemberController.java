package com.darren.microboot.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.darren.microboot.service.IMemberServcie;

@RestController
@RequestMapping("/member")
public class MemberController extends AbstractBaseController {

	@Resource
	private IMemberServcie memberService;

	@RequestMapping(value = "get", method = RequestMethod.POST)
	public Object get(String mid) {
		return memberService.get(mid);
	}

	@RequestMapping(value = "auth", method = RequestMethod.POST)
	public Object auth(String mid) {
		return memberService.listAuthByMember(mid);
	}

}
