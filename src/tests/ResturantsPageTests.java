package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.hotfood.models.Menu;
import com.hotfood.models.ResturantsModel;

public class ResturantsPageTests {
	private final static String MENU_FILE = "validMenu.csv";
	private static String menuId;
	
//	@BeforeClass
//	public static void beforeTests() {
//		System.out.print("hello world2");
////		menuId = UUID.randomUUID().toString();
////		TestFilesHelper.setMenu(MENU_FILE, menuId);
//	}
	
	@BeforeAll
	public static void init() {
		menuId = UUID.randomUUID().toString();
		TestFilesHelper.addUser(menuId,"resturants@test.com");
		TestFilesHelper.setMenu(MENU_FILE, menuId);
	}
	
	@AfterAll
	public static void cleanUp() {
		TestFilesHelper.removeMenu(menuId);
	}
	
	@Test
	public void getResturantsForUser() {
		ResturantsModel model = new ResturantsModel();
		List<Menu> menus = model.getResturants();
		assertTrue(menus.size()>0);
	}
	
	@Test
	public void findResturantInResturants() {
		ResturantsModel model = new ResturantsModel();
		List<Menu> menus = model.getResturants();
		assertTrue(menus.size()>0);
		
		int found = 0;
		for(int i=0;i<menus.size();i++) {
			String id = menus.get(i).getResturantId();
			if(id.equals(menuId)) {
				found++;
			}
		}
		
		assertEquals(1, found,String.format("Excepected to find 1 and found %s", found));
	}
		
	@Test
	public void tryToFindNotExistedMenu() {
		ResturantsModel model = new ResturantsModel();
		List<Menu> menus = model.getResturants();
		String fakeId = "AAAA";
		boolean found = false;
		for(int i=0;i<menus.size();i++) {
			String id = menus.get(i).getResturantId();
			if(id.equals(fakeId)) {
				found = true;
				break;
			}
		}
		
		assertFalse(found,"Found unexisted menu");
	}
		
}
