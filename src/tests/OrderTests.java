package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hotfood.enums.DeliveryOption;
import com.hotfood.enums.SaveOrderStatus;
import com.hotfood.handlers.FilesHandler;
import com.hotfood.models.Customer;
import com.hotfood.models.Dish;
import com.hotfood.models.DishInCart;
import com.hotfood.models.OrderModel;
import com.hotfood.models.User;

class OrderTests {
	
	static private Customer customer;
	
	@BeforeAll
	private static void init() {
		String id = UUID.randomUUID().toString();
		customer = new Customer(id,"cart@test.com","123","Cart Test user");
		List<DishInCart> dishes = new ArrayList<DishInCart>();
		String [] options = new String[] {"1","2","3","4"};
		Dish dish = new Dish(UUID.randomUUID().toString(),"Dish test","test",options,100);
		DishInCart dishInCart = new DishInCart(dish, 1, id);
		customer.addDishToCart(dishInCart);
		
	}
	
	@AfterAll
	private static void cleanup(){
		TestFilesHelper.deleteCart(customer.getId());
	}
	
	@Test
	void createValidOrder() {
		OrderModel orderModel = new OrderModel(customer);
		SaveOrderStatus status = orderModel.saveOrder("test", "test", "test", "test", "A", "test", DeliveryOption.TAKEAWAY);
		assertEquals(SaveOrderStatus.SUCCESS,status);
	}
	
	@Test
	void createOrderBadName() {
		OrderModel orderModel = new OrderModel(customer);
		SaveOrderStatus status = orderModel.saveOrder("", "test", "test", "test", "A", "test", DeliveryOption.TAKEAWAY);
		assertEquals(SaveOrderStatus.BAD_NAME,status);
	}
	@Test
	void createOrderBadLastName() {
		OrderModel orderModel = new OrderModel(customer);
		SaveOrderStatus status = orderModel.saveOrder("a", "", "test", "test", "A", "test", DeliveryOption.TAKEAWAY);
		assertEquals(SaveOrderStatus.BAD_LAST_NAME,status);
	}
	@Test
	void createOrderBadCity() {
		OrderModel orderModel = new OrderModel(customer);
		SaveOrderStatus status = orderModel.saveOrder("a", "test", "", "test", "A", "test", DeliveryOption.TAKEAWAY);
		assertEquals(SaveOrderStatus.BAD_CITY,status);
	}
	@Test
	void createOrderBadStreet() {
		OrderModel orderModel = new OrderModel(customer);
		SaveOrderStatus status = orderModel.saveOrder("a", "test", "test", "", "A", "test", DeliveryOption.TAKEAWAY);
		assertEquals(SaveOrderStatus.BAD_STREET,status);
	}
	@Test
	void createOrderBadFloor() {
		OrderModel orderModel = new OrderModel(customer);
		SaveOrderStatus status = orderModel.saveOrder("a", "test", "test", "test", "", "test", DeliveryOption.TAKEAWAY);
		assertEquals(SaveOrderStatus.BAD_FLOOR,status);
	}
	@Test
	void createOrderBadApartment() {
		OrderModel orderModel = new OrderModel(customer);
		SaveOrderStatus status = orderModel.saveOrder("a", "test", "test", "test", "a", "", DeliveryOption.TAKEAWAY);
		assertEquals(SaveOrderStatus.BAD_APARTMENT,status);
	}
	
}
