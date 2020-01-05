package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	
	@Pointcut("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void performAPIAnalytics() {
		System.out.println("\n======>>> Performing API analytics");
	}

}
