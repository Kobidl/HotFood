package com.hotfood.models;

import java.util.List;
import java.util.Date;

import com.hotfood.handlers.FilesHandler;
import com.hotfood.interfaces.RestaurantInterface;

public class Restaurant extends User implements RestaurantInterface {
	private Menu menu;
	
	//C'tor
	public Restaurant(String id,String email,String password,String name){
		super(id,email,password,name,"0");		
		initMenu();
	}
	
	public Restaurant(User user) {
		super(user);
		initMenu();
	}
	
	private void initMenu(){
		this.menu = FilesHandler.getMenu(super.getId(),super.getName());
		
	}
	
	public Menu getMenu(){
		return this.menu;
	}

	public void updateMenu(List<Dish> dishes) {
		this.menu.setDishes(dishes);
	}
	
}
