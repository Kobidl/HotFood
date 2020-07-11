package com.hotfood.controllers;

import java.util.Observable;
import java.util.Observer;

import com.hotfood.enums.DeliveryOption;
import com.hotfood.interfaces.Controller;
import com.hotfood.models.CartModel;
import com.hotfood.models.MainModel;
import com.hotfood.models.OrderModel;
import com.hotfood.views.CartView;
import com.hotfood.views.OrderView;

public class OrderController implements Controller  {

	OrderView orderView;
	OrderModel orderModel;
	
	public OrderController(OrderView orderView, OrderModel orderModel) {
		this.orderView = orderView;
		this.orderModel = orderModel;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof OrderView) {
			String name = this.orderView.getName();
			String lastName = this.orderView.getLastName();
			String city = this.orderView.getCity();
			String street = this.orderView.getStreet();
			String floor = this.orderView.getFloor();
			String apartment = this.orderView.getApartment();
			DeliveryOption delivery = this.orderView.takeAwaySelected() ? DeliveryOption.TAKEAWAY : DeliveryOption.DELVEIERY;
			this.orderModel.saveOrder(name,lastName,city,street,floor,apartment,delivery);
		}else if(o instanceof OrderModel) {
			
		}
	}
	
}
