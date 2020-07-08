package com.hotfood.models;

import java.util.List;
import java.util.Date;

import com.hotfood.handlers.FilesHandler;

public class Restaurant extends User {
	private List<Menu> menus;
	private Date arrivalTime;
	
	public Restaurant(String id,String email,String password,String name){
		//Check if user exists
		super(id,email,password,"0",name);		

	}
	
	public List<Menu> getMenu(){
		return this.menus;
	}
	
	public Date getArrivalTime() {
		return this.arrivalTime;
	}
	
	public void editArrivalTime(Date time) {
		
	}
}