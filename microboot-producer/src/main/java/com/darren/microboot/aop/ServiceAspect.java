package com.darren.microboot.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

	private Logger logger = LoggerFactory.getLogger(ServiceAspect.class);

	@Around("execution(* com.darren.microboot..service..*.*(..))")
	public Object arroundInvoke(ProceedingJoinPoint point) throws Throwable {
		logger.info("[*********ServiceAspect****arroundInvoke*********]执行参数" + Arrays.toString(point.getArgs()));
		Object obj = point.proceed(point.getArgs());
		logger.info("[*********ServiceAspect****arroundInvoke*********]执行结果" + obj);
		return obj;
	}

}
