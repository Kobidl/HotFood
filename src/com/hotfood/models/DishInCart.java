package com.hotfood.models;

public class DishInCart extends Dish {
	private int[] selectedOptions;
	
	public DishInCart(Dish dish,int [] selectedOptions) {
		super(dish);
		this.selectedOptions = selectedOptions;
	}
	
	
}
