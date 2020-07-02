package com.hotfood.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class FilesController {
	
	private final static String path = "data/users";

	public static boolean checkIfUserExistInUsers(String username,String password) {
		BufferedReader reader;
		boolean found = false;
		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine().trim();
			
			while (line != null) {
				String [] details = line.split(";");
				if(details.length > 1) {
					String user = details[0];
					String pass = details[1];
					if(username.equals(user) && (password== null || password.equals(pass))) {
						System.out.print("found");
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
	
	public static boolean createNewUser(String username,String password,int type) {
		String line = System.lineSeparator() + username +";"+ password+";"+type;
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
}
