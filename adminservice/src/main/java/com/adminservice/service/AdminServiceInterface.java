package com.adminservice.service;

import java.util.List;

import com.adminservice.entity.Customer;
import com.adminservice.entity.Orders;
import com.adminservice.entity.Product;

public interface AdminServiceInterface {

	int createProfile(Customer customer);

	Customer adminLoginService(Customer customer);

	int updateOrderStatusService(int orderid);

	List<Orders> getAllOrderes();

	List<Product> getAllProducts();

	List<Customer> getAllCustomers();

	Customer getCustomerById(String cid);

	int deleteorderById(int int1);

	Product editorderById(int int1);

	int editproduct(Product pp);

}
