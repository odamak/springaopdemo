package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.FriendDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.dao.PageDAO;

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
		FriendDAO theFriendDAO = context.getBean("friendDAO", FriendDAO.class);
//		FriendDAO theFriendDAO2 = context.getBean("friendDAO", FriendDAO.class);
		PageDAO thePageDAO = context.getBean("pageDAO", PageDAO.class);

		// call the business method
		theAccountDAO.addAccount();

		// call the membership business method
		theMembershipDAO.addAccount();

		// call the add friend method with one arg
		theFriendDAO.addFriend("omar");

		// call the add friend method with 2 args
//		theFriendDAO2.addFriend("omar", "damak");
		
		// call the add fan method with 2 arg
		thePageDAO.addFan("Gladiator", 200);

		// close the context
		context.close();

		return "main-test";
	}

}
