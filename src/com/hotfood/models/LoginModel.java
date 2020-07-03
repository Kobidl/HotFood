package com.hotfood.models;

import javax.swing.JOptionPane;

import com.hotfood.handlers.FilesHandler;

public class LoginModel {
	
	
	public User login(String e,String p) {
		User user = null;
		String email = e.trim();
		String password = p.trim();
		if(email.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "One of the required fields is missing!");
		}else {
			user = FilesHandler.getUserFromUsers(email, password);
			if(user == null) {
				JOptionPane.showMessageDialog(null, "User not found!");
			}
		}
		return user;
	}
	
	public boolean register(String e,String p,int type) {
		String email = e.trim();
		String password = p.trim();
		boolean success = false;
		if(email.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "One of the required fields is missing!");
		}else {
			boolean exists = FilesHandler.checkIfUserExistInUsers(email);
			if(exists) {
				JOptionPane.showMessageDialog(null,"User already found with this email");
			}else {
				success = FilesHandler.createNewUser(email,password,type);
				if(success) {
					JOptionPane.showMessageDialog(null,"User Created successfully");
				}else {
					JOptionPane.showMessageDialog(null,"Failed to create the user");
				}
			}
		}
		
		return success;
	}
	
}
