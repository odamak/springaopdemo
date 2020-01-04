package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class PageDAO {
public String addFan(String nameFan, int currentFanNumber) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING A FAN NAMED "+ nameFan +" WITH NUMBER "+ currentFanNumber);
		return "I am the return String of PageDAO.addFan";
		
	}

}
