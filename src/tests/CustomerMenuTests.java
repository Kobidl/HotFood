package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hotfood.handlers.FilesHandler;
import com.hotfood.models.Dish;
import com.hotfood.models.DishInCart;
import com.hotfood.models.Menu;
import com.hotfood.models.MenuForCustomerModel;

public class CustomerMenuTests {
	private static Menu menu;
	private static final String resName = "Test cusomet menu";
	private static final int dishNum = 10;
	private static String userId;
	
	@BeforeAll
	public static void init() {
		String resturantId = UUID.randomUUID().toString();
		String resturantName = resName;
		List<Dish> dishes = new ArrayList<Dish>() {};
		String[] options = new String[] {"test1","test2","test3","test4"};
		for(int i=0;i<dishNum;i++) {
			String dishId = UUID.randomUUID().toString();
			Dish dish = new Dish(dishId,"Dish test","Dish for testing",options,10.4);
			dishes.add(dish);
		}
		menu = new Menu(resturantId, resturantName, dishes);
	}
	
	@AfterEach
	public void cleanup() {
		if(userId!= null && !userId.isEmpty()) {
			TestFilesHelper.deleteCart(userId);
			userId = null;
		}
	}
	
	@Test
	public void getMenuDetails() {
		MenuForCustomerModel menuForCus = new MenuForCustomerModel(menu);
		assertTrue(menu.getResturantName().equals(menuForCus.getResturantName()));
		assertEquals(menu.getDishesSize(),menuForCus.getDishes().size());
		
	}

	@Test
	public void addItemFromMenu() {
		MenuForCustomerModel menuForCus = new MenuForCustomerModel(menu);
		userId = UUID.randomUUID().toString();
		menuForCus.addItem(0, 0, userId);
		
		List<DishInCart> cart = FilesHandler.getCartData(userId);
		assertTrue("Failed to find user cart data", cart.size() == 1);
	}
	
	@Test
	public void checkHalfEmptyOptions() {
		String resturantId = UUID.randomUUID().toString();
		String resturantName = resName;
		List<Dish> dishes = new ArrayList<Dish>() {};
		String[] options = new String[] {"test1","test2","",""};

		String dishId = UUID.randomUUID().toString();
		Dish dish = new Dish(dishId,"Dish test","Dish for testing",options,10.4);
		dishes.add(dish);

		Menu menu = new Menu(resturantId, resturantName, dishes);
		MenuForCustomerModel menuForCus = new MenuForCustomerModel(menu);
		String[] cleanOptions = menuForCus.getDishes().get(0).cleanOptions();
		assertEquals("Something wrong with cleaning the filters",2, cleanOptions.length);
	}
	
}
