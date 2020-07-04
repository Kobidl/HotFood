package com.hotfood.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.hotfood.enums.WindowStates;
import com.hotfood.models.Customer;
import com.hotfood.models.MainModel;
import com.hotfood.models.ResturantsModel;
import com.hotfood.views.MainView;
import com.hotfood.views.ResturantsView;

public class MainController {

	private MainView mainView;
	private MainModel mainModel;
	private ResturantsModel resturantsModel;
	
	public MainController(MainView mainView, MainModel mainModel, ResturantsView resturantsView, ResturantsModel resturantsModel) {
		this.mainView = mainView;
		this.mainModel = mainModel;
		this.resturantsModel = resturantsModel;
		resturantsView.addEnterResturantListener(new EnterResturantListener());
	}
	
	
	public void switchWindowToResturants(Customer customer) {
		this.mainView.setCustomer(customer);
		resturantsModel.load();
		this.mainView.switchWindow(WindowStates.Resturants);
	}
	
	class EnterResturantListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mainView.switchWindow(WindowStates.MenuForCustomer);
		}

	}

}
