package com.hotfood.models;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.hotfood.handlers.FilesHandler;

public class ResturantsModel extends DefaultTableModel {

	private static final Object[][] DATA = null;
	private static final Object[] TABLE_HEADER = { "Resturant Name", "Dishes"};
	private List<Menu> resturants;
	
	public ResturantsModel(Customer customer) {
		super(DATA,TABLE_HEADER);
	}
	
	
    @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
	
	public void load() {
		this.resturants = FilesHandler.getMenus();
		Object[][] newData = new Object[resturants.size()][];
		for (int i = 0; i < this.resturants.size(); i++) {
			Menu menu = this.resturants.get(i);
			newData[i] = new Object[]{menu.getResturantName(),menu.getDishesSize()};
			this.setDataVector(newData, TABLE_HEADER);
		}
	}

}
