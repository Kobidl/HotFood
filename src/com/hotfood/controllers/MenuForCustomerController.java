package com.hotfood.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import com.hotfood.models.DishInCart;
import com.hotfood.models.MainModel;
import com.hotfood.models.Menu;
import com.hotfood.models.MenuForCustomerModel;
import com.hotfood.views.MenuForCustomerView;

public class MenuForCustomerController implements Observer  {

	private MenuForCustomerView menuView;
	private MenuForCustomerModel menuModel;
	private MainModel mainModel;
	
	public MenuForCustomerController(MenuForCustomerView menuView, MenuForCustomerModel menuModel, MainModel mainModel) {
		this.menuView = menuView;
		this.menuModel = menuModel;
		this.mainModel = mainModel;
		init();
	}
	
	public void init() {
		menuView.setHeader(menuModel.getResturantName() + " - Menu");
		menuView.addDishes(menuModel.getDishes());
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof MenuForCustomerView) {
			if(arg instanceof int[]) {
				int [] value = (int[])arg;
				((MenuForCustomerModel)menuModel).addItem(value[0],value[1],mainModel.getCustomerId());
			}
		}else if(o instanceof MenuForCustomerModel){
			if(arg instanceof DishInCart) {
				mainModel.addItemToCart((DishInCart)arg);				
			}
		}
	}
}
