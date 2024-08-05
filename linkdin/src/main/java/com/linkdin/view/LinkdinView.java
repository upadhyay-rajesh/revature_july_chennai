package com.linkdin.view;

import java.util.Scanner;

import com.linkdin.controller.LinkdinController;
import com.linkdin.controller.LinkdinControllerInterface;
import com.linkdin.utility.LinkdinControllerFactory;

public class LinkdinView {

	public static void main(String[] args) {
		
		String ss="y";
		
		while(ss.equals("y")) {
		System.out.println("***********MAIN MENU***********");
		
		System.out.println("press 1 to create profile");
		System.out.println("press 2 to view profile");
		System.out.println("press 3 to view all profile");
		System.out.println("press 4 to edit profile");
		System.out.println("press 5 to delete profile");
		
		
		//what is out?
		// out is static and final object of PrintStream class declared inside System class
		
		System.err.println("i am error");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter choice");
		int c=sc.nextInt();
		
		LinkdinControllerInterface li=LinkdinControllerFactory.createObject("user");
		//above object creation is not following any design pattern
		//we should create object of a class using creational design pattern from GOF
		//here we should use factory or singleton design pattern
		
		switch(c) {
		case 1 : li.createProfileController();
			break;
		case 2 : li.viewProfileController();
			break;
		case 3 : li.viewAllProfileController();
			break;
		case 4 : li.editProfileController();
		break;
		case 5 : li.deleteProfileController();
		break;
			default:System.out.println("wrong choice");
		}
		System.out.println("press y to continue");
		ss=sc.next();
		
		}

	}

}
