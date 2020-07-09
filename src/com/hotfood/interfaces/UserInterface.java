package com.hotfood.interfaces;
import com.hotfood.enums.UserType;

public interface UserInterface {

	String getId();

	String getEmail();

	UserType getType();

	String getName();
}
