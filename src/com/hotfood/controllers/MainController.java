package com.hotfood.controllers;

import com.hotfood.enums.WindowStates;
import com.hotfood.models.Customer;
import com.hotfood.models.MainModel;
import com.hotfood.models.ResturantsModel;
import com.hotfood.views.MainView;

public class MainController {

	private MainView mainView;
	private MainModel mainModel;
	private ResturantsModel resturantsModel;
	
	public MainController(MainView mainView, MainModel mainModel, ResturantsModel resturantsModel) {
		this.mainView = mainView;
		this.mainModel = mainModel;
		this.resturantsModel = resturantsModel;
	
	}
	
	
	public void switchWindowToResturants(Customer customer) {
		this.mainView.setCustomer(customer);
		this.resturantsModel.init();
		this.mainView.switchWindow(WindowStates.Resturants);
	}

}
