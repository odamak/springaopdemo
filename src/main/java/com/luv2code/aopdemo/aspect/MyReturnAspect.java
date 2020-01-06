package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyReturnAspect {
	
	@AfterReturning(
			pointcut="execution(* createAliasAccount(*))",
			returning="result")
	public void afterReturningCreateAliasAccount(JoinPoint theJoinPoint, String result) {
		System.out.println("\n=====> result is: "+result);
		
	}

}
