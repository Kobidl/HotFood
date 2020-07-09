package com.hotfood.models;

import java.util.List;
import javax.swing.table.DefaultTableModel;

import com.hotfood.handlers.FilesHandler;

@SuppressWarnings("serial")
public class ResturantsModel extends DefaultTableModel {

	private static final Object[][] DATA = null;
	private static final Object[] TABLE_HEADER = { "Resturant Name"};
	private List<Menu> resturants;
	
	public ResturantsModel() {
		super(DATA,TABLE_HEADER);
		this.load();
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
			newData[i] = new Object[]{menu.getResturantName()};
		}
		this.setDataVector(newData, TABLE_HEADER);
	}
	
	public Menu getMenuAt(int index) {
		return this.resturants.get(index);
	}

}
