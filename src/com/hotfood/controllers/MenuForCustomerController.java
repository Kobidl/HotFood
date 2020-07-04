package com.hotfood.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.hotfood.models.Menu;
import com.hotfood.models.MenuForCustomerModel;
import com.hotfood.models.ResturantsModel;
import com.hotfood.views.MenuForCustomerView;
import com.hotfood.views.ResturantsView;

public class MenuForCustomerController {

	private MenuForCustomerView menuView;
	MenuForCustomerModel menuModel;
	
	public MenuForCustomerController(MenuForCustomerView menuView, MenuForCustomerModel menuModel) {
		this.menuView = menuView;
		this.menuModel = menuModel;
		menuView.addTableModel(menuModel);
	}
	
	class ResturantsListListener implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
			
			}
				
		}
	}
	
	class EnterResturantListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
}
