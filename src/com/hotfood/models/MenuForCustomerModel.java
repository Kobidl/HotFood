package com.hotfood.models;

import java.util.List;
import java.util.Observable;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import com.hotfood.handlers.FilesHandler;

public class MenuForCustomerModel extends Observable  {
	private List<Dish> dishes;
	
	public MenuForCustomerModel() {
	}
	

	public void init(Menu menu) {
		this.dishes = menu.getDishes();
	}


	public void addItem() {
		setChanged();
		notifyObservers("a");
	}

}
