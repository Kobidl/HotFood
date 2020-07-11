package com.hotfood.controllers;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import com.hotfood.interfaces.Controller;
import com.hotfood.models.CartModel;
import com.hotfood.models.MainModel;
import com.hotfood.views.CartView;

public class CartController implements Controller  {

	private CartView view;
	private CartModel model;
	private MainModel mainModel;
	
	//C'tor
	public CartController(CartView view, CartModel model, MainModel mainModel) {
		this.view = view;
		this.model = model;
		this.mainModel = mainModel;
		init();
	}
	
	//Init
	private void init() {
		model.init(mainModel.getCustomer());
		view.printItems(model.getDishes());
	}

	//Observer
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof CartView) { //Fire from view
			if(arg instanceof Integer) { //Case when remove item fire
				model.removeItem((int) arg);
			}else { //Case when checkout button fire
				model.checkout();
			}
		}else if(o instanceof CartModel) { //Fire from Model
			if(arg instanceof Boolean) {
				if((Boolean) arg) { //If can go to cart -> moving to cart
					this.mainModel.goToOrder();
				}else { //Can't go to cart -> show message
					JOptionPane.showMessageDialog(null,"You must have at least 1 item in the cart to continue");
				}
			}else { //Updates UI on Dishes
				view.printItems(model.getDishes());
			}
		}
	}
	
}
