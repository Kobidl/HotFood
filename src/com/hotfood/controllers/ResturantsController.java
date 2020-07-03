package com.hotfood.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.hotfood.models.ResturantsModel;
import com.hotfood.views.ResturantsView;

public class ResturantsController {

	private ResturantsView resturantsView;
	ResturantsModel resturantsModel;
	
	public ResturantsController(ResturantsView resturantsPane, ResturantsModel resturantsModel) {
		this.resturantsView = resturantsPane;
		this.resturantsModel = resturantsModel;
		
	}
	
	public void init() {
		this.resturantsModel.load();
		this.resturantsView.addTableModel(resturantsModel);
		this.resturantsView.addListSectionListener(new ResturantsListListener());
		this.resturantsView.addEnterResturantListener(new EnterResturantListener());
	}
	
	class ResturantsListListener implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) 
				resturantsView.setEnterResturantsEnable(true);
		}
	}
	
	class EnterResturantListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
}
