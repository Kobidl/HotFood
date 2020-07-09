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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainView extends JFrame {

	JLayeredPane layeredPane;
	MainModel mainModel;
	JButton cartButton;
	JButton backButton;
	JLabel headerLabel;
	
	public MainView() {
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		this.setTitle("HOTFOOD");
		this.setBounds(100, 100, 547, 574);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.white);
		layeredPane = new JLayeredPane();
		
		cartButton = new JButton("Cart");
		cartButton.setBounds(430, 15, 89, 23);
		
		this.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		backButton = new JButton("Back");
		backButton.setBounds(10, 15, 89, 23);
		
		headerLabel = new JLabel("HotFood");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		headerLabel.setBounds(191, 17, 160, 21);
				
		mainModel = new MainModel();
		MainController mainController = new MainController(this,mainModel);
		
		((MainModel) mainModel).addObserver(mainController);
		
		layeredPane.add(backButton);
		layeredPane.add(cartButton);
		//layeredPane.add(headerLabel);

	}
	
	
	public void switchWindow(WindowStates state,Object arg) {
		layeredPane.removeAll();
		
		switch(state) {
			case Login:
				LoginView loginPane = new LoginView();
				LoginModel loginModel = new LoginModel();
				layeredPane.add(loginPane);
				LoginController loginController = new LoginController(loginPane,loginModel,mainModel);
				break;
			case Resturants:
				ResturantsView resturantsPanel = new ResturantsView();
				layeredPane.add(resturantsPanel.getView());
				ResturantsModel resturantsModel = new ResturantsModel();
				ResturantsController resturantsController = new ResturantsController(resturantsPanel,resturantsModel,mainModel);
				break;
			case MenuForCustomer:
				MenuForCustomerModel menuForCustomerModel = new MenuForCustomerModel((Menu)arg);
				MenuForCustomerView menuForCustomerPanel = new MenuForCustomerView();
				MenuForCustomerController menuForCustomerController = new MenuForCustomerController(menuForCustomerPanel, menuForCustomerModel,mainModel);
				((MenuForCustomerView)menuForCustomerPanel).addObserver(menuForCustomerController);				
				((MenuForCustomerModel)menuForCustomerModel).addObserver(menuForCustomerController);
				layeredPane.add(menuForCustomerPanel.getMenu());
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
		printHeader(state);
		layeredPane.repaint();
		layeredPane.revalidate();		
	}

	public void printHeader(WindowStates state) {
		layeredPane.add(headerLabel);
		if(state!= WindowStates.Login) {
			if(state != WindowStates.Cart) {
				layeredPane.add(cartButton);
			}
			if(state != WindowStates.Resturants) {
				layeredPane.add(backButton);
			}
		}
	}
	
	public void addCartListener(ActionListener listener) {
		cartButton.addActionListener(listener);
	}
	
	public void addBackButtonListener(ActionListener listener) {
		backButton.addActionListener(listener);
	}
}
