package com.darren.microboot.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.darren.microboot.pojo.Worker;
import com.darren.microboot.service.IWorkerService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/worker")
public class WorkerController extends AbstractBaseController {

	@Resource
	private IWorkerService workerService;

	// @RequestMapping(value = "/addPre", method = RequestMethod.GET)
	// public String addPre(HttpServletRequest request,Model model) {
	// request.setAttribute("msg", "内置对象操作");
	// request.setAttribute("requestMessage", "requestMessage");
	// request.getSession().setAttribute("sessionMessage",
	// "session.sessionMessage");
	// request.getServletContext().setAttribute("applicationMessage",
	// "application.applicationMessage");
	// model.addAttribute("url", "http://localhost/worker/addPre");
	// return "worker_add";
	// }

	@ApiOperation(value = "实现人员信息的添加处理", notes = "就是加人的,多么的简单")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "worker", value = "用户详细信息", required = true, dataType = "Worker")})
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Boolean add(@RequestBody Worker worker) {
		System.out.println("MemberController add" + worker);
		return true;
	}

	@ApiOperation(value = "获取指定编号的人员信息", notes = "只需要设置mid的信息就可以获取Member完整信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "mid", value = "用户编号", required = true, dataType = "String")})
	@RequestMapping(value = "get/{mid}", method = RequestMethod.GET)
	public Worker get(@PathVariable("mid") long mid) {
		return workerService.get(mid);
	}

}
