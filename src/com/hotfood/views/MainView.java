package com.hotfood.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.hotfood.controllers.LoginController;
import com.hotfood.controllers.MainController;
import com.hotfood.controllers.MenuForCustomerController;
import com.hotfood.controllers.ResturantsController;
import com.hotfood.enums.WindowStates;
import com.hotfood.models.Customer;
import com.hotfood.models.LoginModel;
import com.hotfood.models.MainModel;
import com.hotfood.models.MenuForCustomerModel;
import com.hotfood.models.ResturantsModel;

public class MainView extends JFrame {

	LoginView loginPane;
	ResturantsView resturantsPane;
	MenuForCustomerView menuForCustomerPane;
	JLayeredPane layeredPane;
	Customer customer;
	
	public MainView() {
		this.setTitle("HOTFOOD");
		this.setBounds(100, 100, 546, 498);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane = new JLayeredPane();
		
		this.getContentPane().add(layeredPane, BorderLayout.CENTER);

		LoginView loginPane = new LoginView();
	
		LoginModel loginModel = new LoginModel();
		
		resturantsPane = new ResturantsView();
		resturantsPane.setBounds(0, 0, 546, 498);
		ResturantsModel resturantsModel = new ResturantsModel();
		
		menuForCustomerPane = new MenuForCustomerView();
		menuForCustomerPane.setBounds(0, 0, 546, 498);
		MenuForCustomerModel menuForCustomerModel = new MenuForCustomerModel();
		
		MainModel mainModel = new MainModel();
		
		MenuForCustomerController menuForCustomerController = new MenuForCustomerController(menuForCustomerPane, menuForCustomerModel);
		ResturantsController resturantsController = new ResturantsController(resturantsPane,resturantsModel,menuForCustomerModel);
		MainController mainController = new MainController(this,mainModel,resturantsPane,resturantsModel); 
		LoginController loginController = new LoginController(loginPane,loginModel,mainController);

		layeredPane.removeAll();
		layeredPane.add(loginPane);
		layeredPane.repaint();
		layeredPane.revalidate();

	}
	
	
	public void switchWindow(WindowStates state) {
		layeredPane.removeAll();
		
		switch(state) {
		case Login:
			layeredPane.add(loginPane);
		case Resturants:
			layeredPane.add(resturantsPane);
		case MenuForCustomer:
			layeredPane.add(menuForCustomerPane);
		default:
			break;
		}
		
		layeredPane.repaint();
		layeredPane.revalidate();		
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
