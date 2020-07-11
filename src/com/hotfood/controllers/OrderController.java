package com.hotfood.controllers;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import com.hotfood.enums.DeliveryOption;
import com.hotfood.enums.SaveOrderStatus;
import com.hotfood.interfaces.Controller;
import com.hotfood.models.CartModel;
import com.hotfood.models.MainModel;
import com.hotfood.models.OrderModel;
import com.hotfood.views.CartView;
import com.hotfood.views.OrderView;

public class OrderController implements Controller  {

	OrderView orderView;
	OrderModel orderModel;
	MainModel mainModel;
	
	public OrderController(OrderView orderView, OrderModel orderModel,MainModel mainModel) {
		this.orderView = orderView;
		this.orderModel = orderModel;
		this.mainModel = mainModel;
		this.orderView.setItemsCount(orderModel.getItemsCount());
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
			if(arg instanceof SaveOrderStatus) {
				switch((SaveOrderStatus) arg) {
				case BAD_NAME:
					JOptionPane.showMessageDialog(null,"Bad name.");
					break;
				case BAD_LAST_NAME:
					JOptionPane.showMessageDialog(null,"Bad last name.");
					break;
				case BAD_CITY:
					JOptionPane.showMessageDialog(null,"Bad city.");
					break;
				case BAD_STREET:
					JOptionPane.showMessageDialog(null,"Bad street.");
					break;
				case BAD_APARTMENT:
					JOptionPane.showMessageDialog(null,"Bad apartment.");
					break;
				case BAD_FLOOR:
					JOptionPane.showMessageDialog(null,"Bad floor.");
					break;
				case SUCCESS:
					JOptionPane.showMessageDialog(null,"Thank you, your order has been created Successfully!.");
					mainModel.checkOutOrder();
					break;
				}
			}
		}
	}
	
}
