package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hotfood.models.Menu;
import com.hotfood.models.Restaurant;
import com.hotfood.models.ResturantOwnerModel;

class OwnerPageTests {

	private static ResturantOwnerModel restaurantModel;
	private static Restaurant restaurant;
	private static String name;
	private static String id;
	@BeforeAll
	public static void init() {
		id = UUID.randomUUID().toString();
		name = UUID.randomUUID().toString().replace("-", "_");
		String email = name + "@resturant.com";
		String password = "123456";
		restaurant = new Restaurant(id, email, password, name);
		restaurantModel = new ResturantOwnerModel(restaurant);
	}
	
	@AfterAll
	public static void cleanUp() {
		TestFilesHelper.removeMenu(id);
	}
	
	@Test
	void checkNewResturant() {
		String resName = restaurantModel.getName();
		Menu resMenu = restaurantModel.getMenu();
		
		assertEquals(name, resName);
		assertEquals(id,resMenu.getResturantId());
		assertEquals(name,resMenu.getResturantName());
		assertEquals(0,resMenu.getDishesSize());
	}

}
