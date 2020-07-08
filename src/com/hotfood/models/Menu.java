package com.hotfood.models;

import java.util.List;

public class Menu {
	private String id;
	private List<Dish> dishes;
	private Restaurant restaurant;
	
	
	public Menu(String id,Restaurant restaurant ) {
		this.id = id;
		this.restaurant = restaurant;

}
	public List<Dish> getDishes(){
		return this.dishes;
	}
	
	public Restaurant getRestaurant(){
		return this.restaurant;
	}
	
	public void addDish(Dish dish)
	{
		
	}
	
	public void deleteDish(Dish dish) 
	{
		
	}
	
}
	
