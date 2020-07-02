package com.hotfood;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class LoginController implements ActionListener {
	
	private JTextField loginUsername;
	private JPasswordField loginPassword;
	private JTextField registerUsername;
	private JPasswordField registerPassword;
	private JTextPane userType;	

	
	public LoginController(JTextField loginUsernameInput, JPasswordField loginPasswordInput, JTextField registerUsernameInput, JPasswordField registerPasswordInput, JTextPane txtpnUserType) {
		super();
		this.loginUsername = loginUsernameInput;
		this.loginPassword = loginPasswordInput;
		this.registerUsername = registerUsernameInput;
		this.registerPassword = registerPasswordInput;
		this.userType = txtpnUserType;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch(command) {
		case "Login":
			login();
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
}
