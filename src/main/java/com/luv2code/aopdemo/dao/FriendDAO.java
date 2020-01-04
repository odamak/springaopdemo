package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class FriendDAO {
	
public String addFriend() {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING A FRIEND");
		return "I am the return String of FriendDAO.addFriend";
		
	}

}
