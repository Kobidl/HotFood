package com.hotfood;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilesController {
	
	public static boolean checkIfUserExistInUsers(String username,String password) {
		BufferedReader reader;
		boolean found = false;
		try {
			reader = new BufferedReader(new FileReader("data/users"));
			String line = reader.readLine().trim();
			
			while (line != null) {
				String [] details = line.split(";");
				if(details.length > 1) {
					String user = details[0];
					String pass = details[1];
					if(username.equals(user) && password.equals(pass)) {
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
}
