package com.onlineshopboot.dao;

import com.onlineshopboot.entity.Customer;

public interface AdminDAOInterface {

	int createProfileDao(Customer c);

	int updateOrderStatusDAO(String parameter);

	String adminLoginDAO(String email, String password);

}
