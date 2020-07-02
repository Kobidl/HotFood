package com.hotfood.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hotfood.models.User;

public class LoginController implements ActionListener {
	
	private JTextField loginEmail;
	private JPasswordField loginPassword;
	private JTextField registerEmail;
	private JPasswordField registerPassword;
	private JComboBox userType;	

	
	public LoginController(JTextField loginEmailInput, JPasswordField loginPasswordInput, JTextField registerEmailInput, JPasswordField registerPasswordInput, JComboBox userTypeSelectBox) {
		super();
		this.loginEmail = loginEmailInput;
		this.loginPassword = loginPasswordInput;
		this.registerEmail = registerEmailInput;
		this.registerPassword = registerPasswordInput;
		this.userType = userTypeSelectBox;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch(command) {
		case "Login":
			login();
			break;
		case "Register":
			register();
			break;
		}
	}
	
	
	private User login(){
		String email = this.loginEmail.getText().trim();
		String password = this.loginPassword.getText().trim();
		User user = null;
		if(email.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "One of the required fields is missing!");
		}else {
			user = FilesController.getUserFromUsers(email, password);
			if(user != null) {
				JOptionPane.showMessageDialog(null, "User Found!");
			}else {
				JOptionPane.showMessageDialog(null, "User not found!");
			}
		}
		return user;
	}
	
	private void register() {
		String email = this.registerEmail.getText().trim();
		String password = this.registerPassword.getText().trim();
		int type = this.userType.getSelectedIndex();
		
		if(email.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "One of the required fields is missing!");
		}else {
			boolean exists = FilesController.checkIfUserExistInUsers(email);
			if(exists) {
				JOptionPane.showMessageDialog(null,"User already found with this email");
			}else {
				boolean success = FilesController.createNewUser(email,password,type);
				if(success) {
					JOptionPane.showMessageDialog(null,"User Created successfully");
				}else {
					JOptionPane.showMessageDialog(null,"Failed to create the user");
				}
			}
		}
	}
}
