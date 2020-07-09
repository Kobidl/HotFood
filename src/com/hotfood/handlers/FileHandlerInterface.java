package com.hotfood.handlers;

import java.io.File;
import java.util.List;
import java.util.Map;
import com.hotfood.models.Dish;
import com.hotfood.models.DishInCart;
import com.hotfood.models.Menu;
import com.hotfood.models.User;

public interface FileHandlerInterface extends FileHandlerConsts {

	User getUserFromUsers(String email,String password);
	
	boolean checkIfUserExistInUsers(String email);
	
	boolean createNewUser(String email,String password,int type,String name);

	List<DishInCart> getCartData(String customerId);
	
	 Map<String,String> getResturants();
	
	List<Dish> getMenuDishes(String path);

	List<Menu> getMenus();
	
	File checkIfCartExists(String customerId);

	boolean addDishToCart(DishInCart dishInCart, String customerId);

	void saveCart(List<DishInCart> dishes, String customerId);
}
