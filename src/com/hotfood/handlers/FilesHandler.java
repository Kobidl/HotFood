package com.hotfood.handlers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.hotfood.enums.DeliveryOption;
import com.hotfood.models.Dish;
import com.hotfood.models.DishInCart;
import com.hotfood.models.Menu;
import com.hotfood.models.User;


//Help methods to work with files
public class FilesHandler implements FileHandlerConsts{

	//In order to handle , inside csv files 
	//Remove " " from the start and end of word if there are
	private static String removeQoutes(String s) {
		return s.replaceAll("^\"+|\"+$", "");
	}
	
	//ReadLine splits and remove " " 
	private static String[] readLine(String line) {
		if(line!=null) {
			line = line.trim();
			String[] details = line.split(readSpliter);
			for(int i=0;i<details.length;i++) {
				details[i] = removeQoutes(details[i]);
			}
			return details;
		}
		else {
			return new String[] {};
		}
	}
	
	public static User getUserFromUsers(String email,String password) {
		User user = null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(usersPath));
			String line = reader.readLine();
			while (line != null) {//Skips empty lines
				String [] details = readLine(line);
				if(details.length >= 5) {//Check if there enough fiels in file
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
			
			while (line != null) {//Skips empty lines
				String [] details = readLine(line);
				if(details.length > 1) {
					String e = details[1];
					if(email.equals(e)) {//Compere emails
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
	
	public static boolean createNewUser(String email,String password,String name,int type) {
		UUID uuid = UUID.randomUUID();
		String[] details = {uuid.toString() ,email,password,name ,Integer.toString(type) };
		String line = String.join("\"" + spliter + "\"", details);
		File f = new File(usersPath);
		boolean created = false;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            bw.newLine();
            bw.append("\"" + line + "\"");
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
				String line = reader.readLine();
				
				while (line != null) {
					if(!line.isEmpty()) {
						String [] details = readLine(line);
						DishInCart dish = new DishInCart(details);
						dishes.add(dish);
					}
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
				String [] details = readLine(line);
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
			
			while (line != null) {//Skips empty lines
				String [] details = readLine(line);
				if(details.length ==0 ) continue;
				if(details.length == 8 || details.length == 10) {
					try {
						Dish dish = new Dish(details);
						dishes.add(dish);
					}
					catch(Exception e) {
						dishes = null;
						break;
					}
				// read next line
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			//e.printStackTrace();
			dishes = null;
		}
		return dishes;
	}

	
	public static void saveMenu(Menu menu) {
		File f = new File (menusPath + menu.getResturantId() + extention);
		 try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, false));
            for(int i=0;i<menu.getDishes().size();i++) {
				 if(i>0)
					 bw.newLine();
				 bw.append("\"" + menu.getDish(i).toString() + "\"");
			 }

            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}

	public static List<Menu> getMenus() {
		Map<String,String> resturants = getResturants();
		List<Menu> menus = new ArrayList<Menu>();
		for (Map.Entry<String, String> entry : resturants.entrySet()) {
			String path = menusPath + entry.getKey()+ extention;
			File f = new File(path);
			if(f.exists() && !f.isDirectory()) { 
				List<Dish> dishes= getMenuDishes(path);
				Menu menu = new Menu(entry.getKey(),entry.getValue(),dishes);
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
            bw.append("\""+line+"\"");
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
				 bw.append("\""+dishes.get(i).toString()+"\"");
			 }

			 bw.close();
		 } catch (IOException e) {
       	System.out.print("Failed to write to cart");
           System.out.println(e.getMessage());
           return;
       }
		
	}

	public static Menu getMenu(String id,String name) {
		Menu menu = null;
		String path = menusPath + id + extention;
		File f = new File(path);
		if(f.exists() && !f.isDirectory()) { 
			List<Dish> dishes = getMenuDishes(path);
			menu = new Menu(id,name,dishes);
		}else {
			try {
				f.createNewFile();
				menu = new Menu(id,name,new ArrayList<Dish>());
			} catch (IOException e) {
				System.out.print("Failed to create cart for user");
				System.out.println(e.getMessage());
			}
		}
		
		return menu;
	}

	public static List<Dish> loadMenu(String id, String name, File file) {
		List<Dish> dishes = null;
		if(!file.getName().endsWith(".csv")) return null;
		
		dishes = getMenuDishes(file.getPath());
		return dishes;
	}

	public static void saveOrder(String customerId,List<DishInCart> dishes,String firstName, String lastName, String city, String street, String floor,
			String apartment, DeliveryOption delivery) {
		File f = new File (ordersPath + UUID.randomUUID().toString() + extention);
		 try {
           BufferedWriter bw = new BufferedWriter(new FileWriter(f, false));
           String [] line = new String[]{customerId,firstName,lastName,city,street,floor,apartment,delivery.toString()};
           bw.append(String.join("\""+spliter+"\"", line));
           for(int i=0;i<dishes.size();i++) {
    	   	 	bw.newLine();
    	   	 	bw.append("\""+dishes.get(i).toString()+"\"");
			 }
           bw.close();
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }
		
	}
}