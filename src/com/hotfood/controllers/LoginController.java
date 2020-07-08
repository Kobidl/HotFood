package com.hotfood.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hotfood.enums.UserType;
import com.hotfood.handlers.FilesHandler;
import com.hotfood.models.Customer;
import com.hotfood.models.LoginModel;
import com.hotfood.models.User;
import com.hotfood.views.LoginView;

public class LoginController {
	
	private LoginView loginView;
	private MainController mainController;
	private LoginModel loginModel;
	
	public LoginController(LoginView loginView,LoginModel loginModel,MainController mainController) {
		super();
		this.loginView = loginView;
		this.mainController = mainController;
		
		this.loginView.addLoginListener(new LoginListener());
		this.loginView.addRegisterListener(new RegisterListener());
		this.loginModel = loginModel;
	}
	
	class LoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			User user = loginModel.login(loginView.getLoginEmail(), loginView.getLoginPassword());
			if(user!=null && user.getType() == UserType.Customer) {
				//Customer customer = new Customer(user);
				mainController.switchWindowToResturants();
			}
			if(user!=null && user.getType() == UserType.Resturant) {
//				Resturant resturant = new Resturant(user);
//				mainController.switchWindowToResturants(resturant);
			}
		}
		
	}
	
	class RegisterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			loginModel.register( loginView.getRegisterEmail(), loginView.getRegisterPassword(), loginView.getSelectedUserType(),loginView.getRegisterName());	
		}
			
	}

}
