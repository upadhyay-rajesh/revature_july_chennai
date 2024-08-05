package com.corejava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Buffered_Inputdemo {

	public static void main(String[] args) throws IOException {
		
		File f2=new File("c:/revatureperungudi/third.txt");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("please enter data");
		String inputdata=br.readLine();
		
		FileOutputStream fwrite=new FileOutputStream(f2);
		
		
		
		for(int i=0;i<inputdata.length();i++) {
			fwrite.write(inputdata.charAt(i));
		}
		fwrite.close();
		
		System.out.println("data coppied");
		

	}

}










