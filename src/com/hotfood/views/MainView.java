package com.hotfood.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.hotfood.controllers.LoginController;
import com.hotfood.controllers.MainController;
import com.hotfood.controllers.ResturantsController;
import com.hotfood.enums.WindowStates;
import com.hotfood.models.Customer;
import com.hotfood.models.LoginModel;
import com.hotfood.models.MainModel;
import com.hotfood.models.ResturantsModel;

public class MainView extends JFrame {

	LoginView loginPane;
	ResturantsView resturantsPane;
	JLayeredPane layeredPane;
	Customer customer;
	
	public MainView() {
		this.setTitle("HOTFOOD");
		this.setBounds(100, 100, 546, 498);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 layeredPane = new JLayeredPane();
		
		this.getContentPane().add(layeredPane, BorderLayout.CENTER);

		
		
		LoginView loginPane = new LoginView();
		loginPane.setBounds(0, 0, 546, 498);
		
		resturantsPane = new ResturantsView();
		resturantsPane.setBounds(0, 0, 546, 498);
		
		ResturantsModel resturantsModel = new ResturantsModel(this.customer);
		LoginModel loginModel = new LoginModel();
		
		
		MainModel mainModel = new MainModel();
		
		ResturantsController resturantsController = new ResturantsController(resturantsPane,resturantsModel);
		MainController mainController = new MainController(this,mainModel,resturantsController); 
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
