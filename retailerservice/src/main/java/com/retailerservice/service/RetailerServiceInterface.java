package com.retailerservice.service;

import java.util.List;

import com.retailerservice.entity.Customer;
import com.retailerservice.entity.Orders;
import com.retailerservice.entity.Product;

public interface RetailerServiceInterface {

	int createProfile(Customer customer);

	Customer adminLoginService(Customer customer);

	int updateOrderStatusService(int orderid);

	List<Orders> getAllOrderes();

	List<Product> getAllProducts();

	List<Customer> getAllCustomers();
	
	
	public int addProductService(Product product);

	
	public Customer customerLoginService(Customer customer);

	int shopingcarttotalnoofitem(int c_id);

}
