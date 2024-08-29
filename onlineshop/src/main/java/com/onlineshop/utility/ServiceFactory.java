package com.onlineshop.utility;

import com.onlineshop.service.CustomerService;
import com.onlineshop.service.CustomerServiceInterface;

public class ServiceFactory {

	public static CustomerServiceInterface getObject(String string) {
		if (string.equals("customer")) {
			return new CustomerService();

		}
		return new CustomerService();
	}
}
