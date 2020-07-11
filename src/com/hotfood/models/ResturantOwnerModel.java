package com.hotfood.models;

import java.io.File;
import java.util.List;
import java.util.Observable;

import com.hotfood.handlers.FilesHandler;

public class ResturantOwnerModel  extends Observable {
	private Restaurant restaurant;
	
	public ResturantOwnerModel(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public Menu getMenu() {
		return this.restaurant.getMenu();
	}
	
	public String getName() {
		return this.restaurant.getName();
	}
	
	public void uploadNewMenu(File file) {
		List<Dish> dishes = FilesHandler.loadMenu(this.restaurant.getId(), this.getName(),file);
		this.restaurant.updateMenu(dishes);
		setChanged();
		notifyObservers();
	}
	
	public void saveMenu() {
		FilesHandler.saveMenu(this.restaurant.getMenu());
	}
	
}
