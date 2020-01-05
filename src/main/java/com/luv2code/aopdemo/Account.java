package com.luv2code.aopdemo;

public class Account {
	
	private String name;
	private String level;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String displayString() {
		System.out.println("Account [name=" + name + ", level=" + level + "]");
		return "Account [name=" + name + ", level=" + level + "]";
	}
	
	

}
