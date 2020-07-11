package com.hotfood.models;

import java.util.List;

import com.hotfood.interfaces.MenuInterface;

public class Menu implements MenuInterface {

	private String resturantId;
	private String resturantName;
	private List<Dish> dishes;
	
	//C'tor
	public Menu(String resturantId,String resturantName,List<Dish> dishes) {
		this.resturantId = resturantId;
		this.resturantName = resturantName;
		this.dishes = dishes;
	}
	
	//Get & Sets
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
	
	public List<Dish> getDishes(){
		return this.dishes;
	}

	public Dish getDish(int index) {
		return	this.dishes.get(index);
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

}
