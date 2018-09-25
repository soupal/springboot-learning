package com.darren.microboot.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(MyHandlerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		
		this.logger.info("[---------MyHandlerInterceptor----------preHandle--------]"
				+ handlerMethod.getBean().getClass().getSimpleName());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		this.logger.info("[---------MyHandlerInterceptor----------postHandle--------]"
				+ handlerMethod.getBean().getClass().getSimpleName());
		this.logger.info("[---------MyHandlerInterceptor----------postHandle--------]" + modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		this.logger.info("[---------MyHandlerInterceptor----------afterCompletion--------]");
	}

}
