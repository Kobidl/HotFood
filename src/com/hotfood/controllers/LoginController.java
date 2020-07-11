package com.hotfood.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.hotfood.enums.RegisterStatus;
import com.hotfood.enums.UserType;
import com.hotfood.enums.WindowStates;
import com.hotfood.interfaces.Controller;
import com.hotfood.models.Customer;
import com.hotfood.models.LoginModel;
import com.hotfood.models.MainModel;
import com.hotfood.models.Menu;
import com.hotfood.models.Restaurant;
import com.hotfood.models.User;
import com.hotfood.views.LoginView;
import com.hotfood.views.LoginView.LoginPanel;

public class LoginController implements Controller {
	
	private LoginPanel loginView;
	private LoginModel loginModel;
	private MainModel mainModel;
	
	public LoginController(LoginPanel loginView,LoginModel loginModel,MainModel mainModel) {
		super();
		this.loginView = loginView;
		this.mainModel = mainModel;
		this.loginModel = loginModel;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof LoginModel) {
			if(arg instanceof RegisterStatus) {
				registerCallback((RegisterStatus)arg);
			}
			else if(arg instanceof User) {
				loginCallback((User) arg);
			}else {
				JOptionPane.showMessageDialog(null,"Something went wrong. Please check your details and try again.");
			}
		}else if(o instanceof LoginView) {
			if( arg instanceof ActionEvent) {
				ActionEvent event = (ActionEvent)arg;
				if(event.getActionCommand() == "Login") {
					loginModel.login(loginView.getLoginEmail(), loginView.getLoginPassword());
				}else if(event.getActionCommand() == "Register") {
					loginModel.register( loginView.getRegisterEmail(), loginView.getRegisterPassword(), loginView.getSelectedUserType(),loginView.getRegisterName());
				}
			}
		}
	}
	
	private void loginCallback(User user) {
		if(user == null) {
			JOptionPane.showMessageDialog(null,"Something went wrong. Please check your details and try again.");
		}
		if(user!=null && user.getType() == UserType.Customer) {
			Customer customer = new Customer(user);
			mainModel.goToResturantsPage(customer);
		}
		if(user!=null && user.getType() == UserType.Resturant) {
			Restaurant resturant = new Restaurant(user);
			mainModel.goToResturantPage(resturant);
		}
	}
	
	private void registerCallback(RegisterStatus status) {
		String message = "";
		switch (status) {
		case Success:
			message = "User Created Sucessfully";
			this.loginView.cleanRegisterDetails();
			break;
		case BadEmail:
			message = "Bad email, please try again";
			break;
		case BadPassword:
			message = "Password must have minimum 6 letters, please try again";
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

