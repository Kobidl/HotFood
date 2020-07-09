package com.hotfood.interfaces;

import com.hotfood.enums.WindowStates;
import com.hotfood.models.Customer;
import com.hotfood.models.DishInCart;
import com.hotfood.models.Menu;

public interface MainModelInterface {
	void setState(WindowStates state);
	
	Customer getCustomer();
	
	WindowStates getState();

	void goToResturantsPage(Customer customer);
	
	void goBack();

	void goToCart();
	
	String getCustomerId();

	void goToCutomerMenu(Menu menu);
	
	void addItemToCart(DishInCart dish);
}
