package com.hotfood.models;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.hotfood.handlers.FilesHandler;

public class MenuForCustomerModel extends DefaultTableModel {

	private static final Object[][] DATA = null;
	private static final Object[] TABLE_HEADER = { "Name", "Dishes"};
	private List<Dish> dishes;
	
	public MenuForCustomerModel() {
		super(DATA,TABLE_HEADER);
	}
	
	
    @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
	
	public void load() {
		
	}


	public void init(Menu menu) {
		List<Dish> dishes = menu.getDishes();
		Object[][] newData = new Object[dishes.size()][];
		for (int i = 0; i < dishes.size(); i++) {
			Dish dish = dishes.get(i);
			newData[i] = new Object[]{dish.getName()};
		}
		this.setDataVector(newData, TABLE_HEADER);
	}

}
