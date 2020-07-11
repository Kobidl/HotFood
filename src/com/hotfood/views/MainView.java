package com.hotfood.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import com.hotfood.controllers.CartController;
import com.hotfood.controllers.LoginController;
import com.hotfood.controllers.MainController;
import com.hotfood.controllers.MenuForCustomerController;
import com.hotfood.controllers.OrderController;
import com.hotfood.controllers.ResturantOwnerController;
import com.hotfood.controllers.ResturantsController;
import com.hotfood.enums.WindowStates;
import com.hotfood.models.CartModel;
import com.hotfood.models.LoginModel;
import com.hotfood.models.MainModel;
import com.hotfood.models.Menu;
import com.hotfood.models.MenuForCustomerModel;
import com.hotfood.models.OrderModel;
import com.hotfood.models.Restaurant;
import com.hotfood.models.ResturantOwnerModel;
import com.hotfood.models.ResturantsModel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainView extends JFrame {

	JLayeredPane layeredPane;
	MainModel mainModel;
	JButton cartButton;
	JButton backButton;
	JLabel headerLabel;
	JLabel backlabel;
	
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
		
		headerLabel = new JLabel("HOTFOOD");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		headerLabel.setBounds(185, 17, 160, 21);
				
		mainModel = new MainModel();
		MainController mainController = new MainController(this,mainModel);
		
		((MainModel) mainModel).addObserver(mainController);

		ImageIcon background=new ImageIcon("background/background.png");
	    Image img=background.getImage();
	    Image temp=img.getScaledInstance(650,600,Image.SCALE_SMOOTH);
	    background=new ImageIcon(temp);
	    backlabel = new JLabel(background);
	    backlabel.setLayout(null);
	    backlabel.setBounds(-20,-20,650,600);
	    layeredPane.add(backlabel);
//		layeredPane.add(backButton);
//		layeredPane.add(cartButton);
		//layeredPane.add(headerLabel);

	}
	
	
	public void switchWindow(WindowStates state,Object arg) {
		layeredPane.removeAll();
		switch(state) {
			case Login:
				LoginView loginView = new LoginView();
				LoginModel loginModel = new LoginModel();
				layeredPane.add(loginView.getView());
				LoginController loginController = new LoginController(loginView.getView(),loginModel,mainModel);
				((LoginModel)loginModel).addObserver(loginController);
				((LoginView)loginView).addObserver(loginController);
		
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
				layeredPane.add(menuForCustomerPanel.getView());
				break;
			case Cart:
				CartView cartView = new CartView();
				CartModel cartModel = new CartModel();
				CartController cartController = new CartController(cartView,cartModel,mainModel);
				((CartModel)cartModel).addObserver(cartController);
				((CartView)cartView).addObserver(cartController);
				layeredPane.add(cartView.getView());
				break;
			case ResturantOwner:
				ResturantOwnerView resOwnView = new ResturantOwnerView();
				ResturantOwnerModel resOwnModel = new ResturantOwnerModel(mainModel.getRestaurant());
				ResturantOwnerController resOwnController = new ResturantOwnerController(resOwnView, resOwnModel);
				((ResturantOwnerView)resOwnView).addObserver(resOwnController);
				((ResturantOwnerModel) resOwnModel).addObserver(resOwnController);
				layeredPane.add(resOwnView.getView());
				break;
			case Order:
				OrderView orderView = new OrderView();
				OrderModel orderModel = new OrderModel(mainModel.getCustomer());
				OrderController orderController = new OrderController(orderView,orderModel);
				((OrderModel)orderModel).addObserver(orderController);
				((OrderView)orderView).addObserver(orderController);
				
				layeredPane.add(orderView.getView());
			default:
				break;
		}
		printHeader(state);
		layeredPane.repaint();
		layeredPane.revalidate();		
	}

	public void printHeader(WindowStates state) {
		layeredPane.add(headerLabel);
		if(state!= WindowStates.Login && state != WindowStates.ResturantOwner) {
			if(state != WindowStates.Cart) {
				layeredPane.add(cartButton);
			}
			if(state != WindowStates.Resturants) {
				layeredPane.add(backButton);
			}
		}
		if(backlabel!=null)
			layeredPane.add(backlabel);
	}
	
	public void addCartListener(ActionListener listener) {
		cartButton.addActionListener(listener);
	}
	
	public void addBackButtonListener(ActionListener listener) {
		backButton.addActionListener(listener);
	}
}
