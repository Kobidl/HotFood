package com.hotfood.controllers;

import java.util.Observable;
import java.util.Observer;

import com.hotfood.models.CartModel;
import com.hotfood.models.MainModel;
import com.hotfood.views.CartView;

public class CartController implements Observer  {

	private CartView view;
	private CartModel model;
	private MainModel mainModel;
	
	public CartController(CartView view, CartModel model, MainModel mainModel) {
		this.view = view;
		this.model = model;
		this.mainModel = mainModel;
		init();
	}
	
	private void init() {
		model.init(mainModel.getCustomer());
		view.printItems(model.getDishes());
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof CartView) {
			if(arg instanceof Integer) {
				model.removeItem((int) arg);
			}
		}else if(o instanceof CartModel) {
			view.printItems(model.getDishes());
		}
	}
	
}