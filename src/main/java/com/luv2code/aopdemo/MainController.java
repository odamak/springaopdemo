package com.luv2code.aopdemo;

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

		// close the context
		context.close();

		return "main-test";
	}

}
