package com.hotfood.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.hotfood.enums.WindowStates;
import com.hotfood.models.Menu;
import com.hotfood.models.MenuForCustomerModel;
import com.hotfood.models.ResturantsModel;
import com.hotfood.views.ResturantsView;

public class ResturantsController {

	private ResturantsView resturantsView;
	ResturantsModel resturantsModel;
	MenuForCustomerModel menuForCustomerModel;
	
	
	public ResturantsController(ResturantsView resturantsPane, ResturantsModel resturantsModel, MenuForCustomerModel menuForCustomerModel) {
		this.resturantsView = resturantsPane;
		this.resturantsModel = resturantsModel;
		this.menuForCustomerModel = menuForCustomerModel;
		resturantsPane.addEnterResturantListener(new EnterResturantListener());
		this.init();
	}
	
	public void init() {
		//this.resturantsModel.load();
		this.resturantsView.addTableModel(resturantsModel);
		this.resturantsView.addListSectionListener(new ResturantsListListener());
	}
	
	class ResturantsListListener implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) 
				resturantsView.setEnterResturantsEnable(true);
		}
	}
	
	class EnterResturantListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedRow = resturantsView.getTableSelectedRow();
			Menu menu = resturantsModel.getMenuAt(selectedRow);
			menuForCustomerModel.init(menu);
		}

	}
	
	
}
