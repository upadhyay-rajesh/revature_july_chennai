package com.onlineshopboot.service;

import com.onlineshopboot.entity.Customer;

public interface AdminServiceInterface {

	int createProfile(Customer c);

	int updateOrderStatusService(String parameter);

	String adminLoginService(String email, String password);

}
