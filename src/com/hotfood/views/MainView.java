package com.hotfood.views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import com.hotfood.controllers.LoginController;
import com.hotfood.controllers.MainController;
import com.hotfood.controllers.ResturantsController;
import com.hotfood.enums.WindowStates;
import com.hotfood.models.Customer;
import com.hotfood.models.LoginModel;
import com.hotfood.models.MainModel;
import com.hotfood.models.ResturantOwnerModel;
import com.hotfood.models.ResturantsModel;

public class MainView extends JFrame {

	LoginView loginPane;
	LoginModel loginModel;
	ResturantsView resturantsPane;
	JLayeredPane layeredPane;
	Customer customer;
	ResturantOwnerView restaurantOwnerPane;
	ResturantOwnerModel resturantOwnerModel;

	ResturantsModel resturantsModel;
	
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
		
		restaurantOwnerPane = new ResturantOwnerView();
		restaurantOwnerPane.setBounds(0, 0, 546, 498);
		
	
		MainModel mainModel = new MainModel();
		MainController mainController = new MainController(this,mainModel,resturantsModel); 
		LoginController loginController = new LoginController(loginPane,loginModel,mainController);
		ResturantsController resturantsController = new ResturantsController(resturantsPane,resturantsModel);

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
		case ResturantOnwer:
			layeredPane.add(restaurantOwnerPane);
			
		default:
			break;
		}
		
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void setRestaurantOwnerPane() {
		this.restaurantOwnerPane = new  ResturantOwnerView();
	}
}
