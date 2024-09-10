package com.onlineshopboot.dao;

import com.onlineshopboot.entity.Customer;
import com.onlineshopboot.entity.Product;

public interface RetailerDAOInterface {

	int createProfileDao(Customer c);

	int addProductDAO(Product product);

	Customer customerLoginDAO(String email, String pass);

}
