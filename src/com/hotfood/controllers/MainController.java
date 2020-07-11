package com.hotfood.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import com.hotfood.enums.WindowStates;
import com.hotfood.interfaces.Controller;
import com.hotfood.models.MainModel;
import com.hotfood.models.Menu;
import com.hotfood.models.Restaurant;
import com.hotfood.views.MainView;

public class MainController implements Controller {

	private MainView mainView;
	private MainModel mainModel;
	
	//C'tor
	public MainController(MainView mainView, MainModel mainModel) {
		this.mainView = mainView;
		this.mainModel = mainModel;
		
		//Init window state
		this.mainView.switchWindow(WindowStates.Login,null);
		
		//Buttons registrations
		mainView.addCartListener(new GotoCartListener());
		mainView.addBackButtonListener(new BackListener());
		this.mainView.addLogoutButtonListener(new LogoutListener());
		
		
	}
	
	class LogoutListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mainModel.logOut();
		}
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
	
	
	//Observer
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof MainModel) {
			if(arg instanceof WindowStates) {//WindowState->move to window
				this.mainView.switchWindow((WindowStates)arg, null);
			}
			else if(arg instanceof Menu ) {//Menu->move to menu page
				this.mainView.switchWindow(WindowStates.MenuForCustomer,arg);
			}
		}
	}

}
