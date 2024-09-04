package com.demoboot.dao;

import java.util.List;

import com.demoboot.entity.Customer;

public interface DemoDAOInterface {

	int createProfile(Customer c);

	int loginProfile(Customer c);

	List<Customer> displayAllProfile();

}
