package com.onlineshopboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshopboot.dao.AdminDAOInterface;
import com.onlineshopboot.dao.RetailerDAOInterface;
import com.onlineshopboot.entity.Customer;
import com.onlineshopboot.entity.Product;

@Service

public class RetailerService implements RetailerServiceInterface{
	
	@Autowired
	private RetailerDAOInterface rdao;

	@Override
	public int createProfile(Customer c) {
		// TODO Auto-generated method stub
		return rdao.createProfileDao(c);
	}

	@Override
	public int addProductService(Product product) {
		// TODO Auto-generated method stub
		return rdao.addProductDAO(product);
	}

	@Override
	public Customer customerLoginService(String email, String pass) {
		return rdao.customerLoginDAO(email,pass);
	}

}
