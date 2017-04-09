package com.wch.entity;

import java.io.Serializable;

public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;

	private int age = 0;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	

}
