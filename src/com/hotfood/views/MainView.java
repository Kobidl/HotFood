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
import com.hotfood.models.Menu;
import com.hotfood.models.MenuForCustomerModel;
import com.hotfood.models.ResturantsModel;
import javax.swing.JButton;

public class MainView extends JFrame {

	LoginView loginPane;
	ResturantsView resturantsPanel;
	MenuForCustomerView menuForCustomerPanel;
	JLayeredPane layeredPane;
	Customer customer;
	MenuForCustomerController menuForCustomerController;
	MainModel mainModel;
	JButton cartButton;
	MenuForCustomerModel menuForCustomerModel;
	
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
		
		resturantsPanel = new ResturantsView();

		ResturantsModel resturantsModel = new ResturantsModel();
				
		mainModel = new MainModel();
		MainController mainController = new MainController(this,mainModel,resturantsPanel,resturantsModel);
	
		
		ResturantsController resturantsController = new ResturantsController(resturantsPanel,resturantsModel,mainModel);
		
		
		((MainModel) mainModel).addObserver(mainController);
		
		LoginController loginController = new LoginController(loginPane,loginModel,mainModel);

		layeredPane.removeAll();
		layeredPane.add(loginPane);
		
		layeredPane.repaint();
		layeredPane.revalidate();

	}
	
	
	public void switchWindow(WindowStates state,Object arg) {
		layeredPane.removeAll();
		
		switch(state) {
			case Login:
				layeredPane.add(loginPane);
				break;
			case Resturants:
				layeredPane.add(resturantsPanel.getView());
				printHeader();
				break;
			case MenuForCustomer:
				menuForCustomerModel = new MenuForCustomerModel((Menu)arg);
				menuForCustomerPanel = new MenuForCustomerView();
				
				menuForCustomerController = new MenuForCustomerController(menuForCustomerPanel, menuForCustomerModel,mainModel);
				
				((MenuForCustomerView)menuForCustomerPanel).addObserver(menuForCustomerController);				
				((MenuForCustomerModel)menuForCustomerModel).addObserver(menuForCustomerController);
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
