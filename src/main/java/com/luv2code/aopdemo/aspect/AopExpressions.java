package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*())")
	public void methodForDAOPackageWithNoParam() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*())")
	public void getter() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(*))")
	public void setter() {}
	
	@Pointcut("methodForDAOPackageWithNoParam() && !(getter() || setter())")
	public void MethodDefaultPackageNoGetterSetter() {}

}
