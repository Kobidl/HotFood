package com.hotfood.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.hotfood.enums.WindowStates;
import com.hotfood.interfaces.MainModelInterface;

public class MainModel extends Observable implements MainModelInterface {

	private WindowStates state = WindowStates.Login;
	private Customer customer;
	private Restaurant restaurant;
	private List<WindowStates> history = new ArrayList<WindowStates>();
	
	public MainModel() {}
	
	public MainModel(WindowStates state) {
		this.state = state;
	}
	
	public void setState(WindowStates state) {
		this.state = state;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public WindowStates getState() {
		return this.state;
	}

	public void goToResturantsPage(Customer customer) {
		this.customer = customer;
		this.state = WindowStates.Resturants;
		setChanged();
		notifyObservers(this.state);
	}
	
	public void goBack() {
		if(this.history.size() > 0) {
			int index = this.history.size()-1;
			this.state = this.history.get(index);
			this.history.remove(index);
		}
		setChanged();
		notifyObservers(this.state);
	}
	
	public void goToCart() {
		history.add(state);
		this.state = WindowStates.Cart;
		setChanged();
		notifyObservers(this.state);
	}

	public String getCustomerId() {
		return this.customer.getId();
	}

	public void goToCutomerMenu(Menu menu) {
		history.add(WindowStates.Resturants);
		this.state = WindowStates.MenuForCustomer;
		setChanged();
		notifyObservers(menu);
		
	}

	public void addItemToCart(DishInCart dish) {
		customer.addDishToCart(dish);
		
	}

	public void goToResturantPage(Restaurant resturant) {
		this.restaurant = resturant;
		this.state = WindowStates.ResturantOwner;
		setChanged();
		notifyObservers(WindowStates.ResturantOwner);
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void goToOrder() {
		this.history.add(this.state);
		this.state = WindowStates.Order;
		setChanged();
		notifyObservers(WindowStates.Order);
	}

	public void checkOutOrder() {
		this.history = new ArrayList<WindowStates>();
		this.state = WindowStates.Resturants;
		this.customer.cleanCart();
		setChanged();
		notifyObservers(this.state);
	}

	public void logOut() {
		if(this.customer != null) {
			this.customer = null;
		}
		if(this.restaurant != null) {
			this.restaurant = null;
		}
		this.history = new ArrayList<WindowStates>();
		this.state = WindowStates.Login;
		setChanged();
		notifyObservers(this.state);
		
	}

}
