package com.hotfood.models;

import com.hotfood.interfaces.UserInterface;
import com.hotfood.enums.UserType;

public class User implements UserInterface {
	private String id;
	private String email;
	private String password;
	private UserType type;
	
	public User() {
		
	}
	
	public User(String id,String email,String password,String userType) {
		this.email = email;
		this.password = password;
		this.type = userType == "0" ? UserType.Resturant : UserType.Customer;
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public UserType getType() {
		return this.type;
	}
	
}
