package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.luv2code.aopdemo.aspect.AopExpressions;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> Checking logging");
	}
	
	@Before("com.luv2code.aopdemo.aspect.AopExpressions.MethodDefaultPackageNoGetterSetter()")
	public void beforeDefaultPackageAdvice() {
		System.out.println("\n======>>> Performing checks on DAO package before any method execution that is no getter and no setter and that has no parameter");
	}

}
