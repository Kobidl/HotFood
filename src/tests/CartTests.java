package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hotfood.handlers.FilesHandler;
import com.hotfood.models.CartModel;
import com.hotfood.models.Customer;
import com.hotfood.models.Dish;
import com.hotfood.models.DishInCart;

class CartTests {
	static Customer customer;
	
	@BeforeAll
	static void init() {
		String id = UUID.randomUUID().toString();
		List<DishInCart> dishes = new ArrayList<DishInCart>();
		String [] options = new String[] {"1","2","3","4"};
		Dish dish = new Dish(UUID.randomUUID().toString(),"Dish test","test",options,100);
		DishInCart dishInCart = new DishInCart(dish, 1, id);
		dishes.add(dishInCart);
		FilesHandler.saveCart(dishes, id);
		customer = new Customer(id,"cart@test.com","123","Cart Test user");

	}
	
	@AfterAll
	public static void cleanUp() {
		TestFilesHelper.deleteCart(customer.getId());
	}
	
	@Test
	void checkCart() {
		CartModel cart = new CartModel();
		cart.init(customer);
		
		assertEquals(1,cart.getDishes().size(),"Failed to load cart dishes");
	}
	
	
}
