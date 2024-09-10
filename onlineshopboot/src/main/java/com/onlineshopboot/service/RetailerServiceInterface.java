package com.onlineshopboot.service;

import com.onlineshopboot.entity.Customer;
import com.onlineshopboot.entity.Product;

public interface RetailerServiceInterface {

	int createProfile(Customer c);

	int addProductService(Product product);

	Customer customerLoginService(String email, String pass);

}
