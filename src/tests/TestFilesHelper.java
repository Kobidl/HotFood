package tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.hotfood.handlers.FileHandlerConsts;

import static java.nio.file.StandardCopyOption.*;

public class TestFilesHelper implements TestFilesHelperConsts{

	public static void setMenu(String testFile,String newId) {
		Path source = Paths.get(testsMenusPath+testFile);
		Path dest = Paths.get(menusPath+newId+extention);
		try {
			Files.copy(source,dest, REPLACE_EXISTING);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public static void removeMenu(String menuId) {
		Path path = Paths.get(menusPath+menuId+extention);
		try {
			Files.delete(path);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	public static void addUser(String id, String email) {
		String[] details = {id ,email,"1","Test" ,"0" };
		String line = String.join("\"" + spliter + "\"", details);
		File f = new File(usersPath);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            bw.newLine();
            bw.append("\"" + line + "\"");
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
		
	}

	public static void deleteCart(String userId) {
		try {
			Path path = Paths.get(cartsPath+userId+extention);
			Files.delete(path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
		
	}
	
}
