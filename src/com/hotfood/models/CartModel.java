package com.hotfood.models;

import java.util.List;
import java.util.Observable;

import com.hotfood.handlers.FilesHandler;

public class CartModel extends Observable {
	
	private List<DishInCart> dishes;
	private String customerId;
	
	//C'tor
	public CartModel() {
		
	}
	
	//Initialize 
	public void	init(Customer customer){
		this.dishes = customer.getCart();
		this.customerId = customer.getId();
	}

	public List<DishInCart> getDishes() {		
		return dishes;
	}

	//Remove item and fire observer
	public void removeItem(int index) {
		dishes.remove(index);
		setChanged();
		notifyObservers();
		FilesHandler.saveCart(dishes,customerId);
	}

	//fire observer to change panel if dishes in cart
	public boolean checkout() {
		boolean status = true;
		if(this.dishes.size() == 0) {
			status = false;
		}
		setChanged();
		notifyObservers(status);
		return status;	
	}
}
