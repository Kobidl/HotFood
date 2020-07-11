package com.hotfood.controllers;

import java.io.File;
import java.util.Observable;

import javax.swing.JOptionPane;

import com.hotfood.enums.UploadFileStatus;
import com.hotfood.interfaces.Controller;
import com.hotfood.models.DishInCart;
import com.hotfood.models.MenuForCustomerModel;
import com.hotfood.models.ResturantOwnerModel;
import com.hotfood.views.MenuForCustomerView;
import com.hotfood.views.ResturantOwnerView;

public class ResturantOwnerController implements Controller {
	
	private ResturantOwnerView view;
	private ResturantOwnerModel model;
	
	//C'tor
	public ResturantOwnerController(ResturantOwnerView view, ResturantOwnerModel model) {
		this.view = view;
		this.model = model;
		init();
	}

	//Initialize
	public void init() {
		view.setHeader(model.getMenu().getResturantName() + " - Menu");
		view.printDishes(model.getMenu().getDishes());
	}

	//Observer
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof ResturantOwnerView) { //Update from view
			if(arg instanceof File) {
				this.model.uploadNewMenu((File)arg);
			}
			else{
				this.model.saveMenu();
			}
		}else if(o instanceof ResturantOwnerModel) { //Update from model
			UploadFileStatus status = (UploadFileStatus)arg;
			if(status == UploadFileStatus.SUCCESS) { //If file loaded print the dishes
				view.printDishes(model.getMenu().getDishes());
				return;
			}
			if(status == UploadFileStatus.BAD_FORMAT) { //Print error on format
				JOptionPane.showMessageDialog(null,"Bad file, expected csv file");
			}else if (status == UploadFileStatus.GENERAL_ERROR) { //Print general error
				JOptionPane.showMessageDialog(null,"Something went wrong. Check the file and try again");
			}
			view.activeDeactiveButtons(true);
			
		}
	}

}

