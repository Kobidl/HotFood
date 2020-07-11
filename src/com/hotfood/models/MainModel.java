package com.hotfood.models;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import com.hotfood.enums.WindowStates;
import com.hotfood.interfaces.MainModelInterface;

public class MainModel extends Observable implements MainModelInterface {

	private WindowStates state;
	private Customer customer;
	private Restaurant restaurant;
	private List<Map.Entry<WindowStates, Object>> history;
	
	public MainModel() {
		this.state = WindowStates.Login;
		initHistory();
	}
	
	public MainModel(WindowStates state) {
		this.state = state;
		initHistory();
	}
	
	private void initHistory() {
		history = new ArrayList<Map.Entry<WindowStates, Object>>();
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
		Object param = null;
		if(this.history.size() > 0) {
			int index = this.history.size()-1;
			this.state = this.history.get(index).getKey();
			this.history.remove(index);	
		}
		if(this.history.size() > 0) {
			int index = this.history.size()-1;
			param = this.history.get(index).getValue();
		}
		setChanged();
		if(param!=null) {
			notifyObservers(param);
		}else {
			notifyObservers(this.state);
		}
	}
	
	private void addToHistory() {
		history.add(new AbstractMap.SimpleEntry<WindowStates, Object>(this.state,null));
	}
	private void addToHistory(Object o) {
		history.add(new AbstractMap.SimpleEntry<WindowStates, Object>(this.state,o));
	}
	
	public void goToCart() {
		addToHistory();
		this.state = WindowStates.Cart;
		setChanged();
		notifyObservers(this.state);
	}

	public String getCustomerId() {
		return this.customer.getId();
	}

	public void goToCutomerMenu(Menu menu) {
		addToHistory(menu);
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
		addToHistory();
		this.state = WindowStates.Order;
		setChanged();
		notifyObservers(WindowStates.Order);
	}

	public void checkOutOrder() {
		initHistory();
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
		initHistory();
		this.state = WindowStates.Login;
		setChanged();
		notifyObservers(this.state);
		
	}

}
