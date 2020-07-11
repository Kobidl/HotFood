package com.hotfood.interfaces;

import com.hotfood.enums.DeliveryOption;
import com.hotfood.enums.SaveOrderStatus;

public interface OrderModelInterface {
	
	public int getItemsCount();
	
	public SaveOrderStatus saveOrder(String firstName,String lastName,String city,String street,String floor,String apartment,DeliveryOption delivery);

}
