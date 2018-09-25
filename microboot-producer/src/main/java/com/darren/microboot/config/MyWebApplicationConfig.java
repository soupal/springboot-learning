package com.darren.microboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.darren.microboot.intercept.MyHandlerInterceptor;

@Configuration
public class MyWebApplicationConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 匹配路径
		registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}
