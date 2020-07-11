package com.hotfood.models;

import java.io.File;
import java.util.List;
import java.util.Observable;

import com.hotfood.enums.UploadFileStatus;
import com.hotfood.handlers.FilesHandler;

public class ResturantOwnerModel  extends Observable {
	private Restaurant restaurant;
	
	
	//C'tor
	public ResturantOwnerModel(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public Menu getMenu() {
		return this.restaurant.getMenu();
	}
	
	public String getName() {
		return this.restaurant.getName();
	}
	
	//Uploading new file from user selection. 
	//If file not in format return error;
	//Try to load menu from file
	//If ok update the resautrant menu 
	//Else return error
	//Notify observer 
	public UploadFileStatus uploadNewMenu(File file) {
		UploadFileStatus status = UploadFileStatus.SUCCESS;
		if(!file.getName().endsWith(".csv")) {
			status = UploadFileStatus.BAD_FORMAT;
		}else {
			List<Dish> dishes = FilesHandler.loadMenu(this.restaurant.getId(), this.getName(),file);
			if(dishes == null) {
				status = UploadFileStatus.GENERAL_ERROR;
			}else {
				this.restaurant.updateMenu(dishes);
			}
		}
		setChanged();
		notifyObservers(status);
		return status;
	}
	
	public void saveMenu() {
		FilesHandler.saveMenu(this.restaurant.getMenu());
	}
	
}
