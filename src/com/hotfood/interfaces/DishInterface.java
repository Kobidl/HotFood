
package com.hotfood.interfaces;


public interface DishInterface  {
	String getId();
	
	String getName();
	
	String getDescription();
	
	String[] getOptions();
	
	double getPrice();
	
	String toString();

	String[] cleanOptions();
}