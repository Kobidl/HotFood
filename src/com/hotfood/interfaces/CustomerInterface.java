package com.hotfood.interfaces;

import java.util.List;

import com.hotfood.models.DishInCart;

public interface CustomerInterface extends UserInterface {
	List<DishInCart> getCart();

	void addDishToCart(DishInCart dish);
}
