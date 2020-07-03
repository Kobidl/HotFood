package com.hotfood.controllers;

import com.hotfood.enums.WindowStates;
import com.hotfood.models.Customer;
import com.hotfood.models.MainModel;
import com.hotfood.models.ResturantsModel;
import com.hotfood.views.MainView;

public class MainController {

	private MainView mainView;
	private MainModel mainModel;
	private ResturantsController resturantsController;
	
	public MainController(MainView mainView, MainModel mainModel, ResturantsController resturantsController) {
		this.mainView = mainView;
		this.mainModel = mainModel;
		this.resturantsController = resturantsController;
	
	}
	
	
	public void switchWindowToResturants(Customer customer) {
		this.mainView.setCustomer(customer);
		this.resturantsController.init();
		this.mainView.switchWindow(WindowStates.Resturants);
	}

}
