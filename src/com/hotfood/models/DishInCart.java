package com.hotfood.models;

public class DishInCart extends Dish {
	private int selectedOption;
	private String resturantId;
	
	public DishInCart(Dish dish,int selectedOption,String resturantId) {
		super(dish);
		this.selectedOption = selectedOption;
		this.resturantId = resturantId;
	}
	
	public DishInCart(String[] details) {
		super(details);
		if(details.length >= 10) {
			resturantId = details[8];
			selectedOption = Integer.parseInt(details[9]);
		}
		
	}

	@Override
	public String toString() {
		String value = super.toString();
		value += "," + resturantId + "," + selectedOption;
		return value;
	}

	public String getSelectedOptionText() {
		String[] options = super.getOptions();
		if(options!= null) {
			if(options.length > selectedOption && selectedOption > -1)
				return options[selectedOption];
			else 
				return "";
		}
		else return "";
	}
	
	public String getResturantId() {
		return this.resturantId;
	}
}
