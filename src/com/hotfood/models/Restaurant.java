package com.hotfood.models;

import java.util.List;
import java.util.Date;

import com.hotfood.handlers.FilesHandler;

public class Restaurant extends User {
	private Menu menu;
	
	public Restaurant(String id,String email,String password,String name){
		super(id,email,password,"0",name);		
		initMenu();
	}
	
	public Restaurant(User user) {
		super(user);
		initMenu();
	}
	
	public void initMenu(){
		this.menu = FilesHandler.getMenu(super.getId(),super.getName());
		
	}
	
	public Menu getMenu(){
		return this.menu;
	}

	public void updateMenu(List<Dish> dishes) {
		this.menu.setDishes(dishes);
	}
	
}
