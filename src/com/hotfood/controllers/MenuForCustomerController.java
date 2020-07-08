package com.hotfood.controllers;

import java.util.Observable;
import java.util.Observer;


import com.hotfood.models.Menu;
import com.hotfood.models.MenuForCustomerModel;
import com.hotfood.views.MenuForCustomerView;

public class MenuForCustomerController implements Observer  {

	private MenuForCustomerView menuView;
	private MenuForCustomerModel menuModel;
	
	public MenuForCustomerController(MenuForCustomerView menuView, MenuForCustomerModel menuModel) {
		this.menuView = menuView;
		this.menuModel = menuModel;
	}
	
	public void init(Menu menu) {
		menuModel.init(menu);
		menuView.addDishes(menu.getDishes());
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof MenuForCustomerView) {
			((MenuForCustomerModel)menuModel).addItem();;
		}else if(o instanceof MenuForCustomerModel){
			
		}
	}
	
}
