package com.hotfood.models;

import java.util.List;

public class Menu {

	private String id;
	private String resturantId;
	private String resturantName;
//	private String name;
	private List<Dish> dishes;
	
	
	public Menu(String id,String resturantId,String resturantName,List<Dish> dishes) {
		this.id = id;
		this.resturantId = resturantId;
		this.resturantName = resturantName;
		this.dishes = dishes;
	}
	
	
	public String getResturantId() {
		return this.resturantId;
	}
	
	public String getResturantName() {
		return this.resturantName;
	}
	
	public int getDishesSize() {
		if(this.dishes!=null) {
			return this.dishes.size();
		}
		return 0;
	}
	 
}
