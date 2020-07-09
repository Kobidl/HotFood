package com.hotfood.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import com.hotfood.enums.WindowStates;
import com.hotfood.models.Customer;
import com.hotfood.models.MainModel;
import com.hotfood.models.Menu;
import com.hotfood.models.MenuForCustomerModel;
import com.hotfood.models.ResturantsModel;
import com.hotfood.views.MainView;
import com.hotfood.views.MenuForCustomerView;
import com.hotfood.views.ResturantsView;

public class MainController implements Observer {

	private MainView mainView;
	private MainModel mainModel;
	
	public MainController(MainView mainView, MainModel mainModel) {
		this.mainView = mainView;
		this.mainModel = mainModel;
		mainView.addCartListener(new GotoCartListener());
		mainView.addBackButtonListener(new BackListener());
		this.mainView.switchWindow(WindowStates.Login,null);
	}
	
	
	class GotoCartListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mainModel.goToCart();
		}
	}
	
	class BackListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mainModel.goBack();
		}
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof MainModel) {
			if(arg == WindowStates.Resturants) {
				this.mainView.switchWindow(WindowStates.Resturants,null);
			}
			if(arg == WindowStates.Cart) {
				this.mainView.switchWindow(WindowStates.Cart,null);
			}
			if(arg instanceof Menu ) {
				this.mainView.switchWindow(WindowStates.MenuForCustomer,arg);
			}
		}
	}

}
