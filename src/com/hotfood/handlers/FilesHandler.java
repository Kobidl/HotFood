package com.hotfood.handlers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

import com.hotfood.models.User;

public class FilesHandler {
	private final static String spliter = ",";

	private final static String path = "C:\\Users\\koral\\git\\HotFood\\data\\users.csv";
	private final static String cartsPath = "data/carts.csv";
	
	
	public static User getUserFromUsers(String email,String password) {
		User user = null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(path));
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
			reader = new BufferedReader(new FileReader(path));
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
		File f = new File(path);
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

	public static void getCartData(String id) {
		File f = new File(cartsPath);
		if(f.exists() && !f.isDirectory()) { 
		    
		}

		
	}
	
	public static void uploadMenuFile(File fileMenu) {
		
	}

}
