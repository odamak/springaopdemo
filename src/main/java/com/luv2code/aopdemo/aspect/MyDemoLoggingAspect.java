package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackage()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n======>>> Checking logging");
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: "+ methodSig);
		Object[] args = theJoinPoint.getArgs();
		for(Object tempArg: args) {
			System.out.println(tempArg);
		}
		System.out.println("\n======>>> End Checking logging");
	}
	
	@Before("com.luv2code.aopdemo.aspect.AopExpressions.MethodDefaultPackageNoGetterSetter()")
	public void beforeDefaultPackageAdvice() {
		System.out.println("\n======>>> Performing checks on DAO package before any method execution that is no getter and no setter and that has no parameter");
	}

}
