package com.hotfood.interfaces;

import java.util.List;

import com.hotfood.models.Dish;

public interface MenuInterface {
	String getResturantId();
	
	String getResturantName();
	
	int getDishesSize();
	
	List<Dish> getDishes();

	Dish getDish(int index);

}
