package com.demoboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoboot.dao.DemoDAOInterface;
import com.demoboot.entity.Customer;


@Service
public class DemoService implements DemoServiceInterface{
	
	@Autowired
	private DemoDAOInterface ddao;

	@Override
	public int createProfile(Customer c) {
		// TODO Auto-generated method stub
		return ddao.createProfile(c);
	}

	@Override
	public int loginProfile(Customer c) {
		// TODO Auto-generated method stub
		return ddao.loginProfile(c);
	}

	@Override
	public List<Customer> viewAllProfile() {
		// TODO Auto-generated method stub
		return ddao.displayAllProfile();
	}

}
