package com.hotfood.handlers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.hotfood.models.Dish;
import com.hotfood.models.DishInCart;
import com.hotfood.models.Menu;
import com.hotfood.models.User;

public class FilesHandler {
	private final static String spliter = ",";
	private final static String extention = ".csv";
	private final static String usersPath = "data/users.csv";
	private final static String cartsPath = "data/carts/";
	private final static String menusPath = "data/menus/";
	
	public static User getUserFromUsers(String email,String password) {
		User user = null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(usersPath));
			String line = reader.readLine().trim();
			
			while (line != null) {
				String [] details = line.split(spliter);
				if(details.length > 1) {
					String e = details[1];
					String p = details[2];
					if(email.equals(e) && (password== null || password.equals(p))) {
						user = new User(details[0], details[1], details[2], details[3],details[4]);
						break;
					}
				}
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static boolean checkIfUserExistInUsers(String email) {
		BufferedReader reader;
		boolean found = false;
		try {
			reader = new BufferedReader(new FileReader(usersPath));
			String line = reader.readLine().trim();
			
			while (line != null) {
				String [] details = line.split(spliter);
				if(details.length > 1) {
					String e = details[1];
					if(email.equals(e)) {
						found = true;
						break;
					}
				}
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return found;
	}
	
	public static boolean createNewUser(String email,String password,int type,String name) {
		UUID uuid = UUID.randomUUID();
		String[] details = {uuid.toString() ,email,password,name ,Integer.toString(type) };
		String line = System.lineSeparator() + String.join(spliter, details);
		File f = new File(usersPath);
		boolean created = false;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            bw.append(line);
            bw.close();
            created = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            created = false;
        }
		
		return created;
	}

	public static List<DishInCart> getCartData(String customerId) {
		List<DishInCart> dishes = new ArrayList<DishInCart>();
		String path = cartsPath + customerId + ".csv";
		File f = new File(path);
		if(f.exists() && !f.isDirectory()) { 
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(path));
				String line = reader.readLine().trim();
				
				while (line != null) {
					String [] details = line.split(spliter);
					DishInCart dish = new DishInCart(details);
					dishes.add(dish);
					// read next line
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return dishes;
	}
	
	private static Map<String,String> getResturants() {
		Map<String, String> resturants = new HashMap<String, String>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(usersPath));
			String line = reader.readLine().trim();
			
			while (line != null) {
				String [] details = line.split(spliter);
				if(details.length > 1) {
					String id = details[0];
					String name = details[3];
					resturants.put(id, name);
				}
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resturants;
	}
	
	private static List<Dish> getMenuDishes(String path) {
		List<Dish> dishes = new ArrayList<Dish>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine().trim();
			
			while (line != null) {
				String [] details = line.split(spliter);
				Dish dish = new Dish(details);
				dishes.add(dish);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dishes;
	}

	public static List<Menu> getMenus() {
		Map<String,String> resturants = getResturants();
		List<Menu> menus = new ArrayList<Menu>();
		for (Map.Entry<String, String> entry : resturants.entrySet()) {
			String path = menusPath + entry.getKey()+ extention;
			File f = new File(path);
			if(f.exists() && !f.isDirectory()) { 
				List<Dish> dishes= getMenuDishes(path);
				Menu menu = new Menu(entry.getKey(),entry.getKey(),entry.getValue(),dishes);
				menus.add(menu);
			}
		}
		
		return menus;
	}
	
	private static File checkIfCartExists(String customerId) {
		String path = cartsPath + customerId + ".csv";
		File f = new File(path);
		if(!f.exists() || f.isDirectory()) { 
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.print("Failed to create cart for user");
				System.out.println(e.getMessage());
				return null;
			}
		}
		return f;
	}

	public static boolean addDishToCart(DishInCart dishInCart, String customerId) {
		File f;
		if((f=checkIfCartExists(customerId))== null) {
			return false;
		}
		String line = dishInCart.toString();
		 try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            bw.newLine();
            bw.append(line);
            bw.close();
        } catch (IOException e) {
        	System.out.print("Failed to write to cart");
            System.out.println(e.getMessage());
            return false;
        }
		return true;
	}

	public static void saveCart(List<DishInCart> dishes, String customerId) {
		File f;
		if((f=checkIfCartExists(customerId))==null) {
			return;
		}
		 try {
			 BufferedWriter bw = new BufferedWriter(new FileWriter(f, false));
			 for(int i=0;i<dishes.size();i++) {
				 if(i>0)
					 bw.newLine();
				 bw.append(dishes.get(i).toString());
			 }

			 bw.close();
		 } catch (IOException e) {
       	System.out.print("Failed to write to cart");
           System.out.println(e.getMessage());
           return;
       }
		
	}
}
