package com.hotfood.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.hotfood.enums.RegisterStatus;
import com.hotfood.enums.UserType;
import com.hotfood.models.Customer;
import com.hotfood.models.LoginModel;
import com.hotfood.models.MainModel;
import com.hotfood.models.User;
import com.hotfood.views.LoginView;

public class LoginController {
	
	private LoginView loginView;
	private LoginModel loginModel;
	private MainModel mainModel;
	
	public LoginController(LoginView loginView,LoginModel loginModel,MainModel mainModel) {
		super();
		this.loginView = loginView;
		this.mainModel = mainModel;
		
		this.loginView.addLoginListener(new LoginListener());
		this.loginView.addRegisterListener(new RegisterListener());
		this.loginModel = loginModel;
	}
	
	class LoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			User user = loginModel.login(loginView.getLoginEmail(), loginView.getLoginPassword());
			if(user == null) {
				JOptionPane.showMessageDialog(null,"User already found with this email");
			}
			if(user!=null && user.getType() == UserType.Customer) {
				Customer customer = new Customer(user);
				mainModel.goToResturantsPage(customer);
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
			RegisterStatus status = loginModel.register( loginView.getRegisterEmail(), loginView.getRegisterPassword(), loginView.getSelectedUserType(),loginView.getRegisterName());
			String message = "";
			switch (status) {
			case Success:
				message = "User Created Sucessfully";
				break;
			case BadEmail:
				message = "Bad email, please try again";
				break;
			case BadPassword:
				message = "Password must have minimum 5 letters, please try again";
				break;
			case BadName:
				message = "Bad name, please try again";
				break;
			case UserExists:
				message = "User is already exists.";
				break;
			case GeneralError:
				message ="Something went wrong. Please try again later";
				break;
			default:
				break;
			}
			
			JOptionPane.showMessageDialog(null,message);
		}
	}
}
