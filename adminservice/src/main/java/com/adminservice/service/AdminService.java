package com.adminservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adminservice.dao.AdminDAOInterface;
import com.adminservice.dao.OrderDAOInterface;
import com.adminservice.dao.ProductDAOInterface;
import com.adminservice.entity.Customer;
import com.adminservice.entity.Orders;
import com.adminservice.entity.Product;

@Service
@Transactional
public class AdminService implements AdminServiceInterface{
	
	@Autowired
	private AdminDAOInterface adminDAO;
	
	@Autowired
	private OrderDAOInterface orderDAO;
	
	@Autowired
	private ProductDAOInterface productDAO;

	@Override
	public int createProfile(Customer customer) {
		int i=0;
		adminDAO.save(customer);
		i=1;
		return i;
	}

	@Override
	public Customer adminLoginService(Customer customer) {
		// TODO Auto-generated method stub
		//adminDAO.loginUser(customer.getEmail(), customer.getPassword());
		
		//Customer c=adminDAO.findAll().get(0);
				
		
		return customer;
	}

	@Override
	public int updateOrderStatusService(int orderid) {
		Optional<Orders> oo=orderDAO.findById(orderid);
		Orders o1=oo.get();
		
		if(o1!=null) {
			if (o1.getOrder_status().equals("Deliver")) {
				o1.setOrder_status("Pending");
				orderDAO.saveAndFlush(o1);
				
				
                   } else {
                	   o1.setOrder_status("Deliver");
       				orderDAO.saveAndFlush(o1);
                   	
                   }
		}
		return 0;
	}

	@Override
	public List<Orders> getAllOrderes() {
		// TODO Auto-generated method stub
		return orderDAO.findAll();
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDAO.findAll();
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return adminDAO.findAll();
	}

	@Override
	public Customer getCustomerById(String cid) {
		Optional<Customer> ll=   adminDAO.findById(Integer.parseInt(cid));
		return ll.get();
	}

}










