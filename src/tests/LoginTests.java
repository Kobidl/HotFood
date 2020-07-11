package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hotfood.enums.RegisterStatus;
import com.hotfood.enums.UserType;
import com.hotfood.handlers.FilesHandler;
import com.hotfood.models.LoginModel;
import com.hotfood.models.User;

class LoginTests {
	private static  LoginModel loginModel;
	private String email;
	private String name;
	private String password;
	
	
	@BeforeAll
	public static void init() {
		loginModel = new LoginModel();
	}
	
	@BeforeEach
	public void beforeTest(){
		name = UUID.randomUUID().toString().replace('-', '_');
		email = name+"@test.com";
		password = "123456";
	}
	
	@Test
	void validLogin() {
		User user = loginModel.login("1", "1");
		assertNotNull(user);
		user.getName();
	}
	
	@Test
	void emptyLogin() {
		User user = loginModel.login("", "");
		assertNull(user);
	}
	
	@Test
	void emptyRegistration() {
		RegisterStatus status = loginModel.register("", "",0, "");
		assertTrue(status != RegisterStatus.Success);
	}
	
	@Test
	void registerValidCustomer() {
		RegisterStatus status = loginModel.register(email, password, 1, name);
		assertEquals(RegisterStatus.Success, status,"User not created altought suppose to be created");
	}
	
	@Test
	void registerCustomerAndLogin() {
		RegisterStatus status = loginModel.register(email, password, 1, name);
		assertEquals(RegisterStatus.Success, status,"User not created altought suppose to be created");
		
		User user = loginModel.login(email, password);
		assertNotNull(user,"Failed to login to user after register");
		assertEquals(name,user.getName());
		assertEquals(email,user.getEmail());
		assertEquals(password,user.getPassword());
		assertEquals(UserType.Customer,user.getType());

	}
	
	@Test
	void registerValidResturant() {
		RegisterStatus status = loginModel.register(email, password, 0, name);
		assertEquals(RegisterStatus.Success, status,"User not created altought suppose to be created");
	}
	
	@Test
	void registerResturantAndLogin() {
		RegisterStatus status = loginModel.register(email, password, 1, name);
		assertEquals(RegisterStatus.Success, status,"User not created altought suppose to be created");
		
		User user = loginModel.login(email, password);
		assertNotNull(user,"Failed to login to user after register");
		assertEquals(name,user.getName());
		assertEquals(email,user.getEmail());
		assertEquals(password,user.getPassword());
		assertEquals(UserType.Customer,user.getType());
	}
	
	@Test
	void registerBadEmail() {
		RegisterStatus status = loginModel.register("", password, 0, name);
		assertEquals(RegisterStatus.BadEmail, status);
		
		status = loginModel.register("test", password, 0, name);
		assertEquals(RegisterStatus.BadEmail, status);
	}

	@Test
	void registerBadName() {
		RegisterStatus status = loginModel.register(email, password, 0, "");
		assertEquals(RegisterStatus.BadName, status);
		
		status = loginModel.register(email, password, 0, "h");
		assertEquals(RegisterStatus.BadName, status);
	}

	@Test
	void registerBadPassword() {
		RegisterStatus status = loginModel.register(email, "", 0, name);
		assertEquals(RegisterStatus.BadPassword, status);
		
		status = loginModel.register(email, "123", 0, name);
		assertEquals(RegisterStatus.BadPassword, status);
	}
		
}
