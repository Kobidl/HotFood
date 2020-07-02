package com.hotfood;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginController implements ActionListener {
	
	private JTextField loginUsername;
	private JPasswordField loginPassword;
	private JTextField registerUsername;
	private JPasswordField registerPassword;
	private JComboBox userType;	

	
	public LoginController(JTextField loginUsernameInput, JPasswordField loginPasswordInput, JTextField registerUsernameInput, JPasswordField registerPasswordInput, JComboBox userTypeSelectBox) {
		super();
		this.loginUsername = loginUsernameInput;
		this.loginPassword = loginPasswordInput;
		this.registerUsername = registerUsernameInput;
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
	
	
	private void login(){
		String username = this.loginUsername.getText().trim();
		String password = this.loginPassword.getText().trim();
		if(username.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "One of the required fields is missing!");
		}else {
			boolean found = FilesController.checkIfUserExistInUsers(username,password);
			if(found) {
				JOptionPane.showMessageDialog(null, "User Found!");
			}else {
				JOptionPane.showMessageDialog(null, "User not found!");
			}
		}
	}
	
	private void register() {
		String username = this.registerUsername.getText().trim();
		String password = this.registerPassword.getText().trim();
		int type = this.userType.getSelectedIndex();
		
		if(username.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "One of the required fields is missing!");
		}else {
			boolean exists = FilesController.checkIfUserExistInUsers(username,null);
			if(exists) {
				JOptionPane.showMessageDialog(null,"User already found");
			}else {
				boolean success = FilesController.createNewUser(username,password,type);
				if(success) {
					JOptionPane.showMessageDialog(null,"User Created successfully");
				}else {
					JOptionPane.showMessageDialog(null,"Failed to create the user");
				}
			}
		}
	}
}
