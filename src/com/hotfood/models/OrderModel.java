package com.hotfood.models;

import java.util.List;
import java.util.Observable;

import com.hotfood.enums.DeliveryOption;
import com.hotfood.enums.SaveOrderStatus;
import com.hotfood.handlers.FilesHandler;

public class OrderModel extends Observable {
	
	private Customer customer;
	
	public OrderModel(Customer customer) {
		this.customer = customer;
	}
	
	public int getItemsCount() {
		return this.customer.getCart().size();
	}
	
	public SaveOrderStatus saveOrder(String firstName,String lastName,String city,String street,String floor,String apartment,DeliveryOption delivery){
		SaveOrderStatus status = SaveOrderStatus.SUCCESS;
		if(firstName.isEmpty()) {
			status = SaveOrderStatus.BAD_NAME;
		}
		if(lastName.isEmpty()) {
			status = SaveOrderStatus.BAD_LAST_NAME;
		}
		if(city.isEmpty()) {
			status = SaveOrderStatus.BAD_CITY;
		}
		if(street.isEmpty()) {
			status = SaveOrderStatus.BAD_STREET;
		}
		if(floor.isEmpty()) {
			status = SaveOrderStatus.BAD_FLOOR;
		}
		if(apartment.isEmpty()) {
			status = SaveOrderStatus.BAD_APARTMENT;
		}
		
		FilesHandler.saveOrder(firstName,lastName,city,street,floor,apartment,delivery);
		
		setChanged();
		notifyObservers(status);
		return status;
	}
	
}
