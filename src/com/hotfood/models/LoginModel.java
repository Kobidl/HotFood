package com.hotfood.models;

import java.util.Observable;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.hotfood.enums.RegisterStatus;
import com.hotfood.handlers.FilesHandler;
import com.hotfood.interfaces.Model;

public class LoginModel extends Observable implements Model {
	
	//C'tor
	public User login(String loginEmail, String loginPassword) {
		User user = getLoginUser(loginEmail, loginPassword);
		setChanged();
		notifyObservers(user);
		return user;
	}
	
	//Get user from file if exists and right details
	private User getLoginUser(String e,String p) {
		User user = null;
		String email = e.trim();
		String password = p.trim();
		if(email.isEmpty() || password.isEmpty()) {
			return user;
		}else {
			user = FilesHandler.getUserFromUsers(email, password);
		}
		return user;
	}
	
	//register return status
	public RegisterStatus register(String e,String p,int type,String n) {
		RegisterStatus status = getRegisterStatus(e,p,type,n);
		setChanged();
		notifyObservers(status);
		return status;
	}
	
	
	//Check if details OK. write to file and return status.
	private RegisterStatus getRegisterStatus(String e,String p,int type,String n) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
				"[a-zA-Z0-9_+&*-]+)*@" + 
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
				"A-Z]{2,7}$";
    
		String email = e.trim();
		String password = p.trim();
		String name = n.trim();
		boolean success = false;
		Pattern pat = Pattern.compile(emailRegex);
		if(email.isEmpty() || !pat.matcher(email).matches()) {
			return RegisterStatus.BadEmail;
		}
		if(password.isEmpty() || password.length() < 6) {
			return RegisterStatus.BadPassword;
		}
		if(name.isEmpty() || name.length() < 2) {
			return RegisterStatus.BadName;
		}
		if(FilesHandler.checkIfUserExistInUsers(email)) {
			return RegisterStatus.UserExists;
		}

		success = FilesHandler.createNewUser(email,password,name,type);
		if(!success) {
			return RegisterStatus.GeneralError;
		}
		
		return RegisterStatus.Success;
	}

}
