package com.whatsapp.view;

import java.util.Scanner;

import com.whatsapp.controller.WhatsappController;
import com.whatsapp.controller.WhatsappControllerInterface;

public class WhasappView {

	public static void main(String[] args) {
		System.out.println("***********MAIN MENU*************");
		System.out.println("press 1 to create profile");
		System.out.println("press 2 to view profile");
		System.out.println("press 3 to edit profile");
		System.out.println("press 4 to delete profile");
		System.out.println("press 5 to search profile");
		System.out.println("press 6 to view all profile");
		System.out.println("press 7 to login profile");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter choice");
		int c=sc.nextInt();
		
		//view want to interact with controller so it must interact using low coupling i.e. via interface
		WhatsappControllerInterface wc=new WhatsappController();
		
		switch(c) {
		case 1 : wc.createProfileController();
			break;
		case 2 :wc.viewProfileController();
			break;
		case 3 :wc.editProfileController();
			break;
		case 4 :wc.deleteProfileController();
			break;
		case 5 :wc.searchProfileController();
			break;
		case 6 :wc.viewAllProfileController();
			break;
		case 7 :wc.loginProfileController();
			break;
			default : System.out.println("wrong choice");
			
		}

	}

}













