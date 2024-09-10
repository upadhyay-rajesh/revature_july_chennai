package com.onlineshopboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshopboot.dao.AdminDAOInterface;
import com.onlineshopboot.entity.Customer;

@Service
public class AdminService implements AdminServiceInterface{
	
	@Autowired
	private AdminDAOInterface adao;

	@Override
	public int createProfile(Customer c) {
		// TODO Auto-generated method stub
		return adao.createProfileDao(c);
	}

	@Override
	public int updateOrderStatusService(String parameter) {
		return adao.updateOrderStatusDAO(parameter);
	}

	@Override
	public String adminLoginService(String email, String password) {
		return adao.adminLoginDAO(email,password);
	}

}
