package com.hotfood.interfaces;

import com.hotfood.enums.RegisterStatus;
import com.hotfood.models.User;

public interface LoginModelInterface {
	User login(String email,String password);
	
	RegisterStatus register(String email,String password,int type,String name);
	
}
