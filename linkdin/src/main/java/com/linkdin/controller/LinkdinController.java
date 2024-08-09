package com.linkdin.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.linkdin.entity.LinkdinUser;
import com.linkdin.exception.ProfileNotFoundException;
import com.linkdin.service.LinkdinService;
import com.linkdin.service.LinkdinServiceInterface;
import com.linkdin.utility.LinkdinServiceFactory;
import com.linkdin.utility.SortByEmail;
import com.linkdin.utility.SortByName;

public class LinkdinController implements LinkdinControllerInterface {
	
	Logger log=Logger.getLogger("LinkdinController");

	public void createProfileController() {
		
		//step 1 start taking input from user
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter name ");
		String name=sc.next();
		System.out.println("Enter Password ");
		String password=sc.next();
		System.out.println("Enter Email ");
		String email=sc.next();
		System.out.println("Enter Address ");
		String address=sc.next();
		
		//1 step end
		//step 2 create object of entity and set all value inside entity to pass to service because of DTO design pattern
		
		LinkdinUser lu=new LinkdinUser();
		lu.setName(name);
		lu.setPassword(password);
		lu.setEmail(email);
		lu.setAddress(address);
		
		//step 2 end
		//step 3 create object of service via interface to maintain low coupling
		LinkdinServiceInterface ls=LinkdinServiceFactory.createObject("user");
		int i=ls.createProfileService(lu);
		
		if(i>0) {
			log.info("profile created at "+LocalDateTime.now());
		}
		else {
			log.error("could not create");
		}

	}

	@Override
	public void viewProfileController() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email to view profile");
		String email=sc.next();
		
		LinkdinUser lu=new LinkdinUser();
		lu.setEmail(email);
		
		LinkdinServiceInterface ls=new LinkdinService();
		LinkdinUser ll=ls.viewProfileService(lu);
		try {
		if(ll!=null) {
			System.out.println("Your profile is ");
			System.out.println("Name is -->"+ll.getName());
			System.out.println("Password is -->"+ll.getPassword());
			System.out.println("Email is --> "+ll.getEmail());
			System.out.println("Address is -->"+ll.getAddress());
		}
		else {
			
			throw new ProfileNotFoundException("Profile Not Found for given mail id "+email);
			
			
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void viewAllProfileController() {
		LinkdinServiceInterface ls=new LinkdinService();
		
		List<LinkdinUser>  ll1=  ls.viewAllProfileService();
		
		System.out.println(ll1.size()+" record found in database");
		
		System.out.println("unsorted result");
		for(LinkdinUser ll:ll1) {
			System.out.println("**************************");
			System.out.println("Name is -->"+ll.getName());
			System.out.println("Password is -->"+ll.getPassword());
			System.out.println("Email is --> "+ll.getEmail());
			System.out.println("Address is -->"+ll.getAddress());
		}
		
		Collections.sort(ll1, new SortByName());
		
		System.out.println("sorted result based on name");
		
		ll1.forEach(ll->{
			System.out.println("**************************");
			System.out.println("Name is -->"+ll.getName());
			System.out.println("Password is -->"+ll.getPassword());
			System.out.println("Email is --> "+ll.getEmail());
			System.out.println("Address is -->"+ll.getAddress());
		});
		
		
		for(LinkdinUser ll:ll1) {
			System.out.println("**************************");
			System.out.println("Name is -->"+ll.getName());
			System.out.println("Password is -->"+ll.getPassword());
			System.out.println("Email is --> "+ll.getEmail());
			System.out.println("Address is -->"+ll.getAddress());
		}
		
		Collections.sort(ll1, new SortByEmail());
		
		System.out.println("sorted result based on email");
		
		//Iterator demo
		Iterator<LinkdinUser> it=ll1.iterator();
		
		while(it.hasNext()) {
			LinkdinUser ll=it.next();
			System.out.println("**************************");
			System.out.println("Name is -->"+ll.getName());
			System.out.println("Password is -->"+ll.getPassword());
			System.out.println("Email is --> "+ll.getEmail());
			System.out.println("Address is -->"+ll.getAddress());
		}
		//List Iterator demo
		ListIterator<LinkdinUser> lit=ll1.listIterator();
		while(lit.hasNext()) {
			LinkdinUser ll=it.next();
			System.out.println("**************************");
			System.out.println("Name is -->"+ll.getName());
			System.out.println("Password is -->"+ll.getPassword());
			System.out.println("Email is --> "+ll.getEmail());
			System.out.println("Address is -->"+ll.getAddress());
		}
		
		while(lit.hasPrevious()) {
			LinkdinUser ll=lit.previous();
			System.out.println("**************************");
			System.out.println("Name is -->"+ll.getName());
			System.out.println("Password is -->"+ll.getPassword());
			System.out.println("Email is --> "+ll.getEmail());
			System.out.println("Address is -->"+ll.getAddress());
		}
		
		for(LinkdinUser ll:ll1) {
			System.out.println("**************************");
			System.out.println("Name is -->"+ll.getName());
			System.out.println("Password is -->"+ll.getPassword());
			System.out.println("Email is --> "+ll.getEmail());
			System.out.println("Address is -->"+ll.getAddress());
		}
	}

	@Override
	public void editProfileController() {
Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email to edit profile");
		String email=sc.next();
		
		LinkdinUser lu=new LinkdinUser();
		lu.setEmail(email);
		
		LinkdinServiceInterface ls=new LinkdinService();
		LinkdinUser ll=ls.viewProfileService(lu);
		try {
		if(ll!=null) {
			System.out.println("Your old profile is ");
			System.out.println("Name is -->"+ll.getName());
			System.out.println("Password is -->"+ll.getPassword());
			System.out.println("Email is --> "+ll.getEmail());
			System.out.println("Address is -->"+ll.getAddress());
			
			System.out.println("press 1 to change password");
			System.out.println("press 2 to change address");
			
			System.out.println("enter choice");
			int c=sc.nextInt();
			
			switch(c) {
			case 1 : System.out.println("enter new password ");
					  String npassword=sc.next();
					  ll.setPassword(npassword);
					  int i=ls.editProfileService(ll);
					  
					  if(i>0) {
						  System.out.println("password changed");
					  }
			
				break;
			case 2 :System.out.println("enter new address ");
			  		String naddress=sc.next();
			  		
			  		ll.setAddress(naddress);
					  int i1=ls.editProfileService(ll);
					  
					  if(i1>0) {
						  System.out.println("Address changed");
					  }
				break;
				default : System.out.println("wrong choice");
			}
		}
		else {
			
			throw new ProfileNotFoundException("Profile Not Found for given mail id "+email);
			
			
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void deleteProfileController() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email to delete profile");
		String email=sc.next();
		
		LinkdinUser lu=new LinkdinUser();
		lu.setEmail(email);
		
		LinkdinServiceInterface ls=new LinkdinService();
		int ll=ls.deleteProfileService(lu);
		if(ll>0) {
			System.out.println("profile deleted");
		}
		
	}

}











