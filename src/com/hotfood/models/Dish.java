package com.hotfood.models;

public class Dish {
	private String id;
	private String name;
	private String description;
	private String[] options;
	private double price;
	
	public Dish(String id,String name,String description,String[] options,double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.options = options;
		this.price = price;
	}
	
	public Dish(Dish dish) {
		this.id = dish.getId();
		this.name = dish.getName();
		this.description = dish.getDescription();
		this.options = dish.getOptions();
		this.price = dish.getPrice();
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String[] getOptions() {
		return this.options;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	@Override
	public String toString() {
	    return name;
	}
	
}
