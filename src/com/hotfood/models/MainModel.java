package com.hotfood.models;

import java.util.Observable;

import com.hotfood.controllers.MainController;
import com.hotfood.enums.WindowStates;
import com.hotfood.views.MainView;

public class MainModel extends Observable  {

	private WindowStates state = WindowStates.Login;
	
	public MainModel() {}
	
	public MainModel(WindowStates state) {
		this.state = state;
	}
	
	public void setState(WindowStates state) {
		this.state = state;
	}
	
	public WindowStates getState() {
		return this.state;
	}

	public void goToResturantsPage() {
		this.state = WindowStates.Resturants;
		
		setChanged();
		notifyObservers(this.state);
	}

}
