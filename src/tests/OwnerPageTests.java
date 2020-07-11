package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hotfood.enums.UploadFileStatus;
import com.hotfood.models.Menu;
import com.hotfood.models.Restaurant;
import com.hotfood.models.ResturantOwnerModel;

class OwnerPageTests {

	private ResturantOwnerModel restaurantModel;
	private Restaurant restaurant;
	private String name;
	private String id;
	private String email;
	private String password;
	
	@BeforeEach
	public void init() {
		id = UUID.randomUUID().toString();
		name = UUID.randomUUID().toString().replace("-", "_");
		email = name + "@resturant.com";
		password = "123456";
	}
	
	@AfterEach
	public void cleanUp() {
		TestFilesHelper.removeMenu(id);
	}
	
	@Test
	void checkNewResturant() {
		
		restaurant = new Restaurant(id, email, password, name);
		restaurantModel = new ResturantOwnerModel(restaurant);
		
		String resName = restaurantModel.getName();
		Menu resMenu = restaurantModel.getMenu();
		
		assertEquals(name, resName);
		assertEquals(id,resMenu.getResturantId());
		assertEquals(name,resMenu.getResturantName());
		assertEquals(0,resMenu.getDishesSize());
	}
	
	@Test
	void checkResturantMenu() {
		TestFilesHelper.setMenu("validMenu.csv", id);
		restaurant = new Restaurant(id, email, password, name);
		restaurantModel = new ResturantOwnerModel(restaurant);
		String resName = restaurantModel.getName();
		Menu resMenu = restaurantModel.getMenu();
		
		assertEquals(name, resName);
		assertEquals(id,resMenu.getResturantId());
		assertEquals(name,resMenu.getResturantName());
		assertNotEquals(0,resMenu.getDishesSize());
	}
	
	@Test
	void checkUploadMenuFileExtention() {
		TestFilesHelper.setMenu("validMenu.csv", id);
		restaurant = new Restaurant(id, email, password, name);
		restaurantModel = new ResturantOwnerModel(restaurant);
		
		File file = new File("datasets/menus/invalidFile.txt");
		UploadFileStatus status = restaurantModel.uploadNewMenu(file);
		
		assertEquals(UploadFileStatus.BAD_FORMAT, status);
		Menu resMenu = restaurantModel.getMenu();
		assertNotEquals(0,resMenu.getDishesSize());
	}
	
	@Test
	void checkUploadInvalidMenu() {
		TestFilesHelper.setMenu("invalidMenu.csv", id);
		restaurant = new Restaurant(id, email, password, name);
		restaurantModel = new ResturantOwnerModel(restaurant);
		
		File file = new File("datasets/menus/invalidMenu.csv");
		UploadFileStatus status = restaurantModel.uploadNewMenu(file);
		
		assertEquals(UploadFileStatus.SUCCESS, status);
		Menu resMenu = restaurantModel.getMenu();
		assertNotEquals(0,resMenu.getDishesSize());
	}
	
	@Test
	void checkUploadDeletedMenu() {
		TestFilesHelper.setMenu("invalidMenu.csv", id);
		restaurant = new Restaurant(id, email, password, name);
		restaurantModel = new ResturantOwnerModel(restaurant);
		
		File file = new File("datasets/menu2.csv");
		UploadFileStatus status = restaurantModel.uploadNewMenu(file);
		
		assertEquals(UploadFileStatus.GENERAL_ERROR, status);
		Menu resMenu = restaurantModel.getMenu();
		assertNotEquals(0,resMenu.getDishesSize());
	}
	
	@Test
	void checkUploadAndSaveMenu() {
		TestFilesHelper.setMenu("menu5items.csv", id);
		restaurant = new Restaurant(id, email, password, name);
		restaurantModel = new ResturantOwnerModel(restaurant);
		Menu resMenu = restaurantModel.getMenu();
		
		assertEquals(5,resMenu.getDishesSize());
		
		File file = new File("datasets/menus/menu10items.csv");
		restaurantModel.uploadNewMenu(file);
		
		resMenu = restaurantModel.getMenu();
		assertEquals(10,resMenu.getDishesSize());
		
		restaurantModel.saveMenu();
		
		Restaurant user = new Restaurant(this.restaurant);
		resMenu = user.getMenu();
		assertEquals(10,resMenu.getDishesSize());
	}
	
	
}
