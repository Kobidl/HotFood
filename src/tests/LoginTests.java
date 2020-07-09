package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
	
	
	
}
