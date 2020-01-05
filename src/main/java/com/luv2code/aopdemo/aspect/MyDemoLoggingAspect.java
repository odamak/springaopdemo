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
	private void methodForDAOPackageWithNoParam() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*())")
	private void getter() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(*))")
	private void setter() {}
	
	@Pointcut("methodForDAOPackageWithNoParam() && !(getter() || setter())")
	private void MethodDefaultPackageNoGetterSetter() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackage()")
	public void performAPIAnalytics() {
		System.out.println("\n======>>> Performing API analytics");
	}
	
	@Before("MethodDefaultPackageNoGetterSetter()")
	public void beforeDefaultPackageAdvice() {
		System.out.println("\n======>>> Performing checks on DAO package before any method execution that is no getter and no setter and that has no parameter");
	}

}
