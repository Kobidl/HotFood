package com.hotfood.models;

import java.util.List;
import java.util.Observable;
import com.hotfood.handlers.FilesHandler;
import com.hotfood.interfaces.Model;

public class MenuForCustomerModel extends Observable implements Model  {
	private Menu menu;
	
	//C'tor
	public MenuForCustomerModel(Menu menu) {
		init(menu);
	}
	
	//Initialize
	public void init(Menu menu) {
		this.menu = menu;
	}

	//Add item, updates the file and notify observer
	public void addItem(int index,int selectedOption,String customerId) {
		Dish dish = this.menu.getDish(index);
		DishInCart dishInCart = new DishInCart(dish,selectedOption,menu.getResturantId());
		FilesHandler.addDishToCart(dishInCart,customerId);
		setChanged();
		notifyObservers(dishInCart);
	}

	public String getResturantName() {
		return menu.getResturantName();
	}


	public List<Dish> getDishes() {
		return this.menu.getDishes();
	}

}
