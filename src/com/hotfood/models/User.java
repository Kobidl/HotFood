package com.hotfood.models;

import com.hotfood.interfaces.UserInterface;

import com.hotfood.enums.UserType;

public class User implements UserInterface {
	private String id;
	private String email;
	private String password;
	private String name;
	private UserType type;
	
	public User(User user) {
		init(user.getId(),user.getEmail(),user.getPassword(),user.getName(),user.getType());
	}

	
	public User(String id,String email,String password,String name,String userType) {
		init(id,email, password, name, (userType == "0" ? UserType.Resturant : UserType.Customer));
	}
	
	private void init(String id,String email,String password,String name,UserType userType){
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.type = userType;
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
