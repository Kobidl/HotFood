package com.hotfood.interfaces;

import javax.swing.JPanel;

public interface DishListView {
	JPanel getView();
	boolean customerMode();
	void addDish(int index,int option);
}
