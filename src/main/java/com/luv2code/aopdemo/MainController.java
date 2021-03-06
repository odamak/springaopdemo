package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

@Controller
@RequestMapping("/main")
public class MainController {

	@GetMapping("/test")
	public String MainTest() {

		System.out.println("hello from /main/test");

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		Account theAccount = new Account();

		// call the business method
		theAccountDAO.addAccount(theAccount, true);

		// call the membership business method
		theMembershipDAO.addAccount();
		
		// call removeAccount to use Pointcuts combination
		theAccountDAO.removeAccount();
		theMembershipDAO.removeAccount();
		
		// call getter and setter to test that Pointcuts combination is not called
		System.out.println("executing setter but no advice");
		theAccountDAO.setTestVariable("hello");
		System.out.println("getter is displaying following without advice: "+theAccountDAO.getTestVariable());
		
		//AfterReturning use case
		theAccountDAO.createAliasAccount(" alias1009");
		
		//AfterReturning another use case
		List<Account> theAccounts = theAccountDAO.findAccounts(false);
		System.out.println("\n\nMain Program: AfterReturningApp");
		System.out.println("---");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		//AfterThrowing use case
		AccountDAO theAccountDAO2 = context.getBean("accountDAO", AccountDAO.class);
		List<Account> theAccounts2 = null;
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts2 = theAccountDAO2.findAccounts(tripWire);
			
		} catch (Exception exc) {
			System.out.println("\n\nMain Program... caught exception: "+exc);
		}
		
		System.out.println("\n\nMain Program... : After Throwing Demo App");
		System.out.println("---");
		System.out.println(theAccounts2);
		System.out.println("\n");
		

		// close the context
		context.close();

		return "main-test";
	}

}
