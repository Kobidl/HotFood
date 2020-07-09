package com.hotfood.models;

import java.util.List;
import java.util.Observable;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import com.hotfood.handlers.FilesHandler;

public class MenuForCustomerModel extends Observable  {
	private List<Dish> dishes;
	private String resturantId;
	
	public MenuForCustomerModel() {
	}
	

	public void init(Menu menu) {
		this.dishes = menu.getDishes();
		this.resturantId = menu.getResturantId();
	}


	public void addItem(int index,int selectedOption,String customerId) {
		Dish dish = dishes.get(index);
		DishInCart dishInCart = new DishInCart(dish,selectedOption,this.resturantId);
		FilesHandler.addDishToCart(dishInCart,customerId);
		setChanged();
		notifyObservers(dishInCart);
	}


	public String getCustomerId() {
		// TODO Auto-generated method stub
		return null;
	}

}
