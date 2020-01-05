package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*())")
	private void removeForDAOPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*())")
	private void getter() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(*))")
	private void setter() {}
	
	@Pointcut("removeForDAOPackage() && !(getter() || setter())")
	private void RemoveDefaultPackageNoGetterSetter() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackage()")
	public void performAPIAnalytics() {
		System.out.println("\n======>>> Performing API analytics");
	}
	
	@Before("RemoveDefaultPackageNoGetterSetter()")
	public void beforeDefaultPackageAdvice() {
		System.out.println("\n======>>> Performing checks on DAO package before any method execution that is no getter and no setter and that has no parameter");
	}

}
