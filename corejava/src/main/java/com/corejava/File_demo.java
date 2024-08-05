package com.corejava;

import java.io.File;
import java.io.IOException;

public class File_demo {

	public static void main(String[] args) throws IOException {
		File f=new File("c:/revatureperungudi/one.txt");
		
		if(f.createNewFile()) {
			System.out.println("file created");
		}

	}

}
