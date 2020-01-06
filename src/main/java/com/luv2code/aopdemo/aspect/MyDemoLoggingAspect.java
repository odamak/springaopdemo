package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	// add a new advice for @AfterReturning on the findAccounts method

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts())", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		// print out the results of the method call
		System.out.println("\n======>>>> Executing @AfterReturning on method: " + method);

		if (!result.isEmpty()) {
			Account tempAccount = result.get(0);
			tempAccount.setName("Daffy Duck");
		}

		// print out the results of the method call
		System.out.println("\n====>>>> result is: " + result);
	}

	// add a new advice for @AfterThrowing on the findAccounts method

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		// print out the results of the method call
		System.out.println("\n======>>>> Executing @AfterThrowing on method: " + method);
		System.out.println("@AfterThrowing is saying: The exception is " + theExc);
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterTFindAccountsAdvice(JoinPoint theJoinPoint) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======>>>> Executing @After on method: " + method);
	}

	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackage()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n======>>> Checking logging for any add method");
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		Object[] args = theJoinPoint.getArgs();
		for (Object tempArg : args) {
			System.out.println(tempArg);
		}
		System.out.println("\n======>>> End Checking logging for any add method");
	}

	@Before("com.luv2code.aopdemo.aspect.AopExpressions.MethodDefaultPackageNoGetterSetter()")
	public void beforeDefaultPackageAdvice() {
		System.out.println(
				"\n======>>> Performing checks on DAO package before any method execution that is no getter and no setter and that has no parameter");
	}
	
	@Around("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public Object aroundFindAccountsAdvice(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		long begin = System.currentTimeMillis();
		Object result = theProceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();
		long duration = end - begin;
		System.out.println("\n======> Duration: "+duration+ " milliseconds");
		return result;
	}

}
