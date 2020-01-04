package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class FriendDAO {

public String addFriend(String nameFriend) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING A FRIEND NAMED "+ nameFriend);
		return "I am the return String of FriendDAO.addFriend";
		
	}
	
public String addFriend(String nameFriend, String lastNameFriend) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING A FRIEND NAMED "+ nameFriend + " " + lastNameFriend);
		return "I am the return String of FriendDAO.addFriend";
		
	}

}
