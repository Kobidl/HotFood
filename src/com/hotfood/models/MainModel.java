package com.hotfood.models;

import com.hotfood.controllers.MainController;
import com.hotfood.enums.WindowStates;
import com.hotfood.views.MainView;

public class MainModel {

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

}
