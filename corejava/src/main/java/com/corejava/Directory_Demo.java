package com.corejava;

import java.io.File;

public class Directory_Demo {

	public static void main(String[] args) {
		File f=new File("c:/revatureperungudi");
		if(f.mkdir()) {
			System.out.println("directory created");
		}
		else {
			System.out.println("could not create");
		}

	}

}
