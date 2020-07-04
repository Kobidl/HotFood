package com.hotfood.models;

import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import com.hotfood.handlers.FilesHandler;

public class MenuForCustomerModel extends DefaultListModel<Dish> {
	private List<Dish> dishes;
	
	public MenuForCustomerModel() {
	}
	

	public void init(Menu menu) {
		List<Dish> dishes = menu.getDishes();
		for (int i = 0; i < dishes.size(); i++) {
			Dish dish = dishes.get(i);
			this.add(i, dish);
		}
	}

}
