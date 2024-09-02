package com.onlineshop.utility;

import com.onlineshop.dao.CustomerDAO;
import com.onlineshop.dao.CustomerDAOInterface;

public class DaoFactory {

	public static CustomerDAOInterface getObject(String string) {
		if(string.equals("customer")) {
			return new CustomerDAO();
		}
		return new CustomerDAO();
	}

}
