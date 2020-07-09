package com.hotfood.models;

import java.util.Observable;

import com.hotfood.controllers.MainController;
import com.hotfood.enums.WindowStates;
import com.hotfood.views.MainView;

public class MainModel extends Observable  {

	private WindowStates state = WindowStates.Login;
	private Customer customer;
	
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

	public void goToResturantsPage() {
		this.state = WindowStates.Resturants;
		setChanged();
		notifyObservers(this.state);
	}
	
	public void goToCart() {
		this.state = WindowStates.Cart;
		setChanged();
		notifyObservers(this.state);
	}

	public void setUser(Customer customer) {
		this.customer = customer;
	}

	public String getCustomerId() {
		return this.customer.getId();
	}

}
