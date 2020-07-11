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

	private void compareMenus(Menu menu1,MenuForCustomerModel menu2) {
		//Asserts
		assertTrue(menu1.getResturantName().equals(menu2.getResturantName()));
		assertEquals(menu1.getDishesSize(),menu2.getDishes().size());
		for(int i=0;i<menu1.getDishesSize();i++) {
			Dish dish1 = menu1.getDish(i);
			Dish dish2 = menu2.getDishes().get(i);
			compereDishes(dish1,dish2);
		}
		
	}
	
	@Test
	public void getMenuDetails() {
		//Arrange
		MenuForCustomerModel menuForCus = new MenuForCustomerModel(menu);
		
		//Asserts
		assertEquals(menu.getResturantName(),menuForCus.getResturantName());
		assertEquals(menu.getDishesSize(),menuForCus.getDishes().size());
		compareMenus(menu,menuForCus);
		
	}

	@Test
	public void addItemFromMenu() {
		//Arrange
		MenuForCustomerModel menuForCus = new MenuForCustomerModel(menu);
		userId = UUID.randomUUID().toString();
		int selectedOption = 1;
		
		//Act 
		menuForCus.addItem(0, selectedOption, userId);

		List<DishInCart> cart = FilesHandler.getCartData(userId);
		
		//Asserts
		assertEquals("Failed to find user cart data",1, cart.size());
		DishInCart dish = cart.get(0);
		assertEquals(dish.getResturantId(),menu.getResturantId());
		assertEquals(menu.getDish(0).getOptions()[selectedOption],dish.getSelectedOptionText());
		compereDishes(menu.getDish(0),dish);
	}
	
	//Asserts help method
	private void compereDishes(Dish dish1,Dish dish2) {
		//Asserts 
		assertEquals(dish1.getId(),dish2.getId());
		assertEquals(dish1.getName(),dish2.getName());
		assertEquals(dish1.getDescription(),dish2.getDescription());
		assertEquals(dish1.getPrice(), dish2.getPrice(),10);
		assertEquals(dish1.getOptions(), dish2.getOptions());
	}
	
	@Test
	public void checkHalfEmptyOptions() {
		//Arrange
		String resturantId = UUID.randomUUID().toString();
		String resturantName = resName;
		List<Dish> dishes = new ArrayList<Dish>() {};
		String[] options = new String[] {"test1","test2","",""};
		String dishId = UUID.randomUUID().toString();
		Dish dish = new Dish(dishId,"Dish test","Dish for testing",options,10.4);
		dishes.add(dish);
		
		//Act
		Menu menu = new Menu(resturantId, resturantName, dishes);
		MenuForCustomerModel menuForCus = new MenuForCustomerModel(menu);
		String[] cleanOptions = menuForCus.getDishes().get(0).cleanOptions();
		//Asserts
		assertEquals("Something wrong with cleaning the filters",2, cleanOptions.length);
	}
	
}
