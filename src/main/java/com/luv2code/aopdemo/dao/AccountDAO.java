package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	String testVariable;

	public String getTestVariable() {
		return testVariable;
	}

	public void setTestVariable(String testVariable) {
		this.testVariable = testVariable;
	}

	public void addAccount(Account theAccount, boolean vipPerson) {

		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

	}

	public void removeAccount() {

		System.out.println(getClass() + ": DOING MY DB WORK: REMOVING AN ACCOUNT");

	}

}
