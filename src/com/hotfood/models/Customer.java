package com.hotfood.models;

import java.util.List;

import com.hotfood.handlers.FilesHandler;

public class Customer extends User {
	private List<DishInCart> cart;
	public Customer(String id,String email,String password){
		//Check if user exists
		super(id,email,password,"1");		
		FilesHandler.getCartData(id);

	}
	
	public Customer(User user) {
		super(user);
		FilesHandler.getCartData(user.getId());
	}
	
	public List<DishInCart> getCart(){
		return this.cart;
	}
}