package com.controller;

import java.util.ArrayList;

public class Roles {
	
	private ArrayList<String> roles=new ArrayList<String>();

	public void addRole(String role)
	{
		roles.add(role);
	}
	public ArrayList<String> getRoles()
	{
		return roles;
	}
	
}
