package com.demoboot.service;

import java.util.List;

import com.demoboot.entity.Customer;

public interface DemoServiceInterface {

	int createProfile(Customer c);

	int loginProfile(Customer c);

	List<Customer> viewAllProfile();

}
