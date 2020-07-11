package com.hotfood.models;

import java.util.ArrayList;
import java.util.List;

import com.hotfood.handlers.FilesHandler;
import com.hotfood.interfaces.CustomerInterface;

public class Customer extends User implements CustomerInterface {
	private List<DishInCart> cart;
	
	public Customer(String id,String email,String password,String name){
		//Check if user exists
		super(id,email,password,"1",name);
		initCart(id);
	}
	
	public Customer(User user) {
		super(user);
		initCart(user.getId());
	}
	
	private void initCart(String userId) {
		this.cart = FilesHandler.getCartData(userId);	
	}
	
	public List<DishInCart> getCart(){
		return this.cart;
	}

	public void addDishToCart(DishInCart dish) {
		this.cart.add(dish);
	}

	public void cleanCart() {
		this.cart = new ArrayList<DishInCart>();
		FilesHandler.saveCart(this.cart, super.getId());

	}
}