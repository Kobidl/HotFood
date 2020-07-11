package com.hotfood.controllers;

import java.util.Observable;
import com.hotfood.interfaces.Controller;
import com.hotfood.models.DishInCart;
import com.hotfood.models.MainModel;
import com.hotfood.models.MenuForCustomerModel;
import com.hotfood.views.MenuForCustomerView;

public class MenuForCustomerController implements Controller  {

	private MenuForCustomerView menuView;
	private MenuForCustomerModel menuModel;
	private MainModel mainModel;
	
	//C'tor
	public MenuForCustomerController(MenuForCustomerView menuView, MenuForCustomerModel menuModel, MainModel mainModel) {
		this.menuView = menuView;
		this.menuModel = menuModel;
		this.mainModel = mainModel;
		
		init();
	}
	
	//Initialize 
	public void init() {
		menuView.setHeader(menuModel.getResturantName() + " - Menu");//Print restaurant name
		menuView.addDishes(menuModel.getDishes()); //Print dishes
	}

	//Observer
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof MenuForCustomerView) {//Update from view
			if(arg instanceof int[]) {//calls model add items
				int [] value = (int[])arg;
				((MenuForCustomerModel)menuModel).addItem(value[0],value[1],mainModel.getCustomerId());
			}
		}else if(o instanceof MenuForCustomerModel){//Update from model
			if(arg instanceof DishInCart) { //update main model -> add item to cart
				mainModel.addItemToCart((DishInCart)arg);				
			}
		}
	}
}
