package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.hotfood.enums.RegisterStatus;
import com.hotfood.enums.UserType;
import com.hotfood.handlers.FilesHandler;
import com.hotfood.models.LoginModel;
import com.hotfood.models.User;

class LoginTests {

	@Test
	void validLogin() {
		LoginModel loginModel = new LoginModel();
		User user = loginModel.login("1", "1");
		assertNotNull(user);
		user.getName();
	}
	
	@Test
	void badLogin() {
		LoginModel loginModel = new LoginModel();
		User user = loginModel.login("", "");
		assertNull(user);
	}
	
	@Test
	void registerValidCustomer() {
		LoginModel loginModel = new LoginModel();
		String name = UUID.randomUUID().toString().replace('-', '_');
		String email = name+"@test.com";
		String password = "123";
		RegisterStatus status = loginModel.register(email, "123", 1, name);
		assertEquals(RegisterStatus.Success, status,"User not created altought suppose to be created");
	}
	
	@Test
	void registerCustomerAndLogin() {
		LoginModel loginModel = new LoginModel();
		String name = UUID.randomUUID().toString().replace('-', '_');
		String email = name+"@test.com";
		String password = "123";
		RegisterStatus status = loginModel.register(email, "123", 1, name);
		assertEquals(RegisterStatus.Success, status,"User not created altought suppose to be created");
		
		User user = loginModel.login(email, password);
		assertNotNull(user,"Failed to login to user after register");
		assertEquals(name,user.getName());
		assertEquals(email,user.getEmail());
		assertEquals(password,user.getPassword());
		assertEquals(UserType.Customer,user.getType());

	}
	
	
	
}
