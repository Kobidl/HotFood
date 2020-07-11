package com.hotfood.models;

import com.hotfood.interfaces.UserInterface;

import com.hotfood.enums.UserType;

public class User implements UserInterface {
	private String id;
	private String email;
	private String password;
	private String name;
	private UserType type;
	
	public User(String id,String email,String password,String name,String userType) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.type = userType.equals("0") ? UserType.Resturant : UserType.Customer;
	}
	
	public User(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.type = user.getType();
	}

	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}
	
	@Override
	public UserType getType() {
		return this.type;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

}
