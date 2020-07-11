package com.hotfood.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.hotfood.interfaces.Controller;
import com.hotfood.models.MainModel;
import com.hotfood.models.Menu;
import com.hotfood.models.ResturantsModel;
import com.hotfood.views.ResturantsView;

public class ResturantsController implements Controller {

	private ResturantsView resturantsView;
	private ResturantsModel resturantsModel;
	private MainModel mainModel;
	
	//C'tor
	public ResturantsController(ResturantsView resturantsPane, ResturantsModel resturantsModel, MainModel mainModel) {
		this.resturantsView = resturantsPane;
		this.resturantsModel = resturantsModel;
		this.mainModel = mainModel;
		
		this.init();
	}
	
	//Initialize
	public void init() {
		//init table
		this.resturantsView.addTableModel(resturantsModel);
		
		//Add buttons listeners
		this.resturantsView.addEnterResturantListener(new EnterResturantListener());
		this.resturantsView.addListSectionListener(new ResturantsListListener());
	}
	
	class ResturantsListListener implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting())//Check if first time selected -> allow "Enter" button 
				resturantsView.setEnterResturantsEnable(true);
		}
	}
	
	class EnterResturantListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {//Enter button fires -> go to menu
			int selectedRow = resturantsView.getTableSelectedRow();
			Menu menu = resturantsModel.getMenuAt(selectedRow);
			mainModel.goToCutomerMenu(menu);
		}

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}
	
}
