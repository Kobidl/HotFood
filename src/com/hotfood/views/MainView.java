package com.hotfood.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.hotfood.controllers.CartController;
import com.hotfood.controllers.LoginController;
import com.hotfood.controllers.MainController;
import com.hotfood.controllers.MenuForCustomerController;
import com.hotfood.controllers.ResturantsController;
import com.hotfood.enums.WindowStates;
import com.hotfood.models.CartModel;
import com.hotfood.models.Customer;
import com.hotfood.models.LoginModel;
import com.hotfood.models.MainModel;
import com.hotfood.models.MenuForCustomerModel;
import com.hotfood.models.ResturantsModel;
import javax.swing.JButton;

public class MainView extends JFrame {

	LoginView loginPane;
	ResturantsView resturantsPane;
	MenuForCustomerView menuForCustomerPanel;
	JLayeredPane layeredPane;
	Customer customer;
	MenuForCustomerController menuForCustomerController;
	MainModel mainModel;
	JButton cartButton;
	
	public MainView() {
		getContentPane().setBackground(Color.WHITE);
		this.setTitle("HOTFOOD");
		this.setBounds(100, 100, 546, 498);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.white);
		layeredPane = new JLayeredPane();
		
		cartButton = new JButton("Cart");
		cartButton.setBounds(430, 15, 89, 23);
		
		this.getContentPane().add(layeredPane, BorderLayout.CENTER);

		LoginView loginPane = new LoginView();
	
		LoginModel loginModel = new LoginModel();
		
		resturantsPane = new ResturantsView();
		resturantsPane.setBounds(0, 40, 546, 498);
		ResturantsModel resturantsModel = new ResturantsModel();
		
		menuForCustomerPanel = new MenuForCustomerView();
		MenuForCustomerModel menuForCustomerModel = new MenuForCustomerModel();
		
		mainModel = new MainModel();
		MainController mainController = new MainController(this,mainModel,resturantsPane,resturantsModel);
		
		menuForCustomerController = new MenuForCustomerController(menuForCustomerPanel, menuForCustomerModel,mainModel);
		((MenuForCustomerModel)menuForCustomerModel).addObserver(menuForCustomerController);
		((MenuForCustomerView)menuForCustomerPanel).addObserver(menuForCustomerController);
		
		ResturantsController resturantsController = new ResturantsController(resturantsPane,resturantsModel,menuForCustomerController);
 
		((MainModel) mainModel).addObserver(mainController);
		
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
				break;
			case Resturants:
				layeredPane.add(resturantsPane);
				printHeader();
				break;
			case MenuForCustomer:
				layeredPane.add(menuForCustomerPanel.getMenu());
				printHeader();
				break;
			case Cart:
				CartView cartView = new CartView();
				CartModel cartModel = new CartModel();
				CartController cartController = new CartController(cartView,cartModel,mainModel);
				((CartModel)cartModel).addObserver(cartController);
				((CartView)cartView).addObserver(cartController);
				layeredPane.add(cartView.getView());
				break;
			default:
				break;
		}
		
		layeredPane.repaint();
		layeredPane.revalidate();		
	}

	public void printHeader() {
		
		layeredPane.add(cartButton);
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void addCartListener(ActionListener listener) {
		cartButton.addActionListener(listener);
	}
}
