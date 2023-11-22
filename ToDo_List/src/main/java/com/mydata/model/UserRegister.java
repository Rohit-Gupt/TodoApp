package com.mydata.model;

import java.io.Serializable;

public class UserRegister implements Serializable{
	
	private String name;
	private String last;
	private String username;
	private String password;
	
	public UserRegister() {}
	public UserRegister(String name, String last, String username, String password) {
		super();
		this.name = name;
		this.last = last;
		this.username = username;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserRegister [name=" + name + ", last=" + last + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	

}
