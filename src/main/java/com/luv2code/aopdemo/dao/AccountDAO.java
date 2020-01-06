package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	public String createAliasAccount(String alias) {
		testVariable = "hihi";
		System.out.println(getClass() + " Executing create Alias Account ... "+ testVariable+alias);
		return(testVariable+alias);
	}
	
	public List<Account> findAccounts(boolean tripWire) {
		
		// for academic purpose ... simulate an exception
		if (tripWire) {
			throw new RuntimeException("No soup for you!!!");
		}
		
		List<Account> myAccounts = new ArrayList<Account>();
		
		// create sample accounts
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");
		
		// add them to our accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}

}
