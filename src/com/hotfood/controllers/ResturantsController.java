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
	ResturantsModel resturantsModel;
	MainModel mainModel;
	
	
	public ResturantsController(ResturantsView resturantsPane, ResturantsModel resturantsModel, MainModel mainModel) {
		this.resturantsView = resturantsPane;
		this.resturantsModel = resturantsModel;
		this.mainModel = mainModel;
		resturantsPane.addEnterResturantListener(new EnterResturantListener());
		this.init();
	}
	
	public void init() {
		//this.resturantsModel.load();
		this.resturantsView.addTableModel(resturantsModel);
		this.resturantsView.addListSectionListener(new ResturantsListListener());
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
			int selectedRow = resturantsView.getTableSelectedRow();
			Menu menu = resturantsModel.getMenuAt(selectedRow);
			mainModel.goToCutomerMenu(menu);
		}

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}
	
	
}
