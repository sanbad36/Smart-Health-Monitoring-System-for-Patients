package com.icu;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class CreateDirectory {
	public static String createdirectory(String str) {
		
		
	      String path = "D:/file/";
	     
	      path = path+str;
	      //Creating a File object
	      File file = new File(path);
	      //Creating the directory
	      boolean bool = file.mkdir();
	      if(bool){
	         System.out.println("Directory created successfully");
	         System.out.println(path);
	         path = path+"//";
	      }else{
	         System.out.println("Sorry couldn’t create specified directory");
	         path = path+"//";
	      }
	      System.out.println(path);
		return path;
		
	}

}
