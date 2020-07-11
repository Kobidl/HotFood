package com.hotfood.interfaces;

import java.util.List;

import com.hotfood.models.Dish;
import com.hotfood.models.Menu;

public interface RestaurantInterface extends UserInterface {
	
	Menu getMenu();

	public void updateMenu(List<Dish> dishes);
	
}
