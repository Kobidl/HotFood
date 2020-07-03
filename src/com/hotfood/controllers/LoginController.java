package com.hotfood.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hotfood.handlers.FilesHandler;
import com.hotfood.models.User;
import com.hotfood.views.LoginView;

public class LoginController {
	
	private LoginView loginView;

	
	public LoginController(LoginView loginView) {
		super();
		this.loginView = loginView;
		
		this.loginView.addLoginListener(new LoginListener());
		this.loginView.addRegisterListener(new RegisterListener());
	}
	
	class LoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			login();
		}
		
		private User login(){
			String email = loginView.getLoginEmail().trim();
			String password = loginView.getLoginPassword().trim();
			User user = null;
			if(email.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "One of the required fields is missing!");
			}else {
				user = FilesHandler.getUserFromUsers(email, password);
				if(user != null) {
					JOptionPane.showMessageDialog(null, "User Found!");
				}else {
					JOptionPane.showMessageDialog(null, "User not found!");
				}
			}
			return user;
		}
	}
	
	class RegisterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			register();
		}
		
		private void register() {
			String email = loginView.getRegisterEmail().trim();
			String password = loginView.getRegisterPassword().trim();
			int type = loginView.getSelectedUserType();
			
			if(email.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "One of the required fields is missing!");
			}else {
				boolean exists = FilesHandler.checkIfUserExistInUsers(email);
				if(exists) {
					JOptionPane.showMessageDialog(null,"User already found with this email");
				}else {
					boolean success = FilesHandler.createNewUser(email,password,type);
					if(success) {
						JOptionPane.showMessageDialog(null,"User Created successfully");
					}else {
						JOptionPane.showMessageDialog(null,"Failed to create the user");
					}
				}
			}
		}	
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String command = e.getActionCommand();
//		switch(command) {
//		case "Login":
//			login();
//			break;
//		case "Register":
//			register();
//			break;
//		}
//	}
//	
	
}
