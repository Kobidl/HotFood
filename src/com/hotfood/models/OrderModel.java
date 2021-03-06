package com.hotfood.models;

import java.util.List;
import java.util.Observable;

import com.hotfood.enums.DeliveryOption;
import com.hotfood.enums.SaveOrderStatus;
import com.hotfood.handlers.FilesHandler;
import com.hotfood.interfaces.OrderModelInterface;

public class OrderModel extends Observable implements OrderModelInterface {
	
	private Customer customer;
	
	//C'tor
	public OrderModel(Customer customer) {
		this.customer = customer;
	}
	
	//Initialize 
	public int getItemsCount() {
		return this.customer.getCart().size();
	}
	
	//Check details. If OK write to file. if not OK return status. notify observer
	public SaveOrderStatus saveOrder(String firstName,String lastName,String city,String street,String floor,String apartment,DeliveryOption delivery){
		SaveOrderStatus status = SaveOrderStatus.SUCCESS;
		firstName = firstName.trim();
		lastName = lastName.trim();
		city = city.trim();
		street = street.trim();
		floor = floor.trim();
		apartment = apartment.trim();
		
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
		
		FilesHandler.saveOrder(this.customer.getId(),this.customer.getCart(),firstName,lastName,city,street,floor,apartment,delivery);
		
		setChanged();
		notifyObservers(status);
		return status;
	}
	
}
