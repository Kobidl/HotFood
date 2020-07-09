package com.hotfood.program;
import java.awt.EventQueue;

import com.hotfood.views.MainView;

public class HotFoodUI {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView mainView = new MainView();
//					MainModel mainModel = new MainModel();
//					MainController mainController = new MainController(mainView,mainModel);
					
					mainView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
