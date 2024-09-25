package com.retailerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retailerservice.dao.OrderDAOInterface;
import com.retailerservice.dao.ProductDAOInterface;
import com.retailerservice.dao.RetailerDAOInterface;
import com.retailerservice.dao.ShopingCartDAOInterface;
import com.retailerservice.entity.Customer;
import com.retailerservice.entity.Orders;
import com.retailerservice.entity.Product;
import com.retailerservice.entity.ShopingCart;

@Service
@Transactional
public class RetailerService implements RetailerServiceInterface{
	
	@Autowired
	private RetailerDAOInterface adminDAO;
	
	@Autowired
	private OrderDAOInterface orderDAO;
	
	@Autowired
	private ProductDAOInterface productDAO;
	
	@Autowired
	private ShopingCartDAOInterface shopingDAO;

	@Override
	public int createProfile(Customer customer) {
		int i=0;
		adminDAO.save(customer);
		i=1;
		return i;
	}

	@Override
	public Customer adminLoginService(Customer customer) {
		
		Customer c=null;
		List<Customer> cc= adminDAO.findAll();
		for(Customer c1:cc) {
			if(c1.getEmail().equals(customer.getEmail()) && c1.getPassword().equals(customer.getPassword())) {
				c=c1;
			}
		}
	
		return c;
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
	public int addProductService(Product product) {
		// TODO Auto-generated method stub
		productDAO.save(product);
		return 1;
	}

	@Override
	public Customer customerLoginService(Customer customer) {
		Customer c=null;
		List<Customer> cc= adminDAO.findAll();
		for(Customer c1:cc) {
			if(c1.getEmail().equals(customer.getEmail()) && c1.getPassword().equals(customer.getPassword())) {
				c=c1;
			}
		}
	
		return c;
	}

	@Override
	public int shopingcarttotalnoofitem(int c_id) {
		int i=0;
		List<ShopingCart> ll=shopingDAO.findAll();
		for(ShopingCart ss:ll) {
			if(ss.getCustomer_id()==c_id) {
				i++;
			}
		}
		return i;
	}

}










