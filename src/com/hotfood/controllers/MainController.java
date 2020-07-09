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
	private ResturantsModel resturantsModel;
	
	public MainController(MainView mainView, MainModel mainModel, ResturantsView resturantsView, ResturantsModel resturantsModel) {
		this.mainView = mainView;
		this.mainModel = mainModel;
		this.resturantsModel = resturantsModel;
		mainView.addCartListener(new GotoCartListener());
	}
	
	
	public void switchWindowToResturants() {
		resturantsModel.load();
		this.mainView.switchWindow(WindowStates.Resturants,null);
	}
	
	class GotoCartListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mainModel.goToCart();
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof MainModel) {
			if(arg == WindowStates.Resturants) {
				switchWindowToResturants();
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
