package com.corejava;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWrite {

	public static void main(String[] args)throws IOException {
		File f2=new File("c:/revatureperungudi/four.txt");
		FileOutputStream fwrite=new FileOutputStream(f2);
		
		Employee e1=new Employee();
		e1.setName("Swathi");
		e1.setPassword("ssss");
		e1.setEmail("swathi@gmail.com");
		e1.setAddress("Chennai");
		e1.setSalary(200000.00f);
		
		ObjectOutputStream out=new ObjectOutputStream(fwrite);
		out.writeObject(e1);
		
		out.close();
		fwrite.close();
		System.out.println("object written");

	}

}







