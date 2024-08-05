package com.corejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Filereadandwritedemo {

	public static void main(String[] args) throws IOException {
		File f1=new File("c:/revatureperungudi/one.txt");
		File f2=new File("c:/revatureperungudi/two.txt");
		
		FileInputStream fread=new FileInputStream(f1);
		FileOutputStream fwrite=new FileOutputStream(f2);
		
		int c=0;
		
		while(!((c=fread.read())==-1)) {
			fwrite.write(c);
		}
		fwrite.close();
		fread.close();
		System.out.println("data coppied");
		

	}

}










