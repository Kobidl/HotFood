
package com.hotfood.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.hotfood.enums.WindowStates;
import com.hotfood.models.Customer;
import com.hotfood.models.MainModel;
import com.hotfood.models.ResturantsModel;
import com.hotfood.views.MainView;
import com.hotfood.views.ResturantOwnerView;
import com.hotfood.views.ResturantsView;

import com.hotfood.models.Customer;
import com.hotfood.models.MainModel;
import com.hotfood.models.Restaurant;
import com.hotfood.models.ResturantsModel;
import com.hotfood.models.ResturantOwnerModel;
import com.hotfood.views.MainView;
import com.hotfood.views.ResturantsView;

public class MainController {

	private MainView mainView;
	private MainModel mainModel;
	private ResturantsModel resturantsModel;
	//private ResturantOwnerModel resturantOwnerModel;
	
	public MainController(MainView mainView, MainModel mainModel, ResturantsModel resturantsModel) { 
		this.mainView = mainView;
		this.mainModel = mainModel;
		this.resturantsModel = resturantsModel;
		//this.resturantOwnerModel = resturantOwnerModel;
		
	}
	
	public void switchWindowToResturants(Customer customer) {
		this.mainView.setCustomer(customer);
		this.resturantsModel.init();
		this.mainView.switchWindow(WindowStates.Resturants);
	}
	
	public void switchWindowToResturantOwnerView() {
	//	this.resturantOwnerModel.init();
		//this.mainView.setRestaurantOwnerPane();
		//this.mainView.switchWindow(WindowStates.ResturantOnwer);
	}

}
