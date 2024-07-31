package com.whatsapp.controller;

import java.util.Scanner;

import com.whatsapp.entity.WhatsappUser;
import com.whatsapp.service.WhatsappService;
import com.whatsapp.service.WhatsappServiceInterface;

public class WhatsappController implements WhatsappControllerInterface {

	public void createProfileController() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter name");
		String name=sc.next();
		
		System.out.println("Enter Password");
		String password=sc.next();
		
		System.out.println("Enter Email");
		String email=sc.next();
		
		System.out.println("Enter Address");
		String address=sc.next();
		
		WhatsappUser wu=new WhatsappUser();
		wu.setName(name);
		wu.setPassword(password);
		wu.setEmail(email);
		wu.setAddress(address);
		
		WhatsappServiceInterface wi=new WhatsappService();
		int i=wi.createProfileService(wu);
		
		if(i>0) {
			System.out.println("Profile created");
		}
		else {
			System.out.println("Profile rejected");
		}

	}

	public void viewProfileController() {
		// TODO Auto-generated method stub

	}

	public void editProfileController() {
		// TODO Auto-generated method stub

	}

	public void deleteProfileController() {
		// TODO Auto-generated method stub

	}

	public void searchProfileController() {
		// TODO Auto-generated method stub

	}

	public void viewAllProfileController() {
		// TODO Auto-generated method stub

	}

	public void loginProfileController() {
		// TODO Auto-generated method stub

	}

}
