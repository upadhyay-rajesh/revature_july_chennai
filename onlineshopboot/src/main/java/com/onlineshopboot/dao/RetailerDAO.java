package com.onlineshopboot.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshopboot.entity.Customer;
import com.onlineshopboot.entity.Product;

@Repository
@Transactional
public class RetailerDAO implements RetailerDAOInterface{

	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public int createProfileDao(Customer c) {
		int addCustomer=0;
		Session ss=sf.openSession();
		EntityTransaction et=ss.getTransaction();
		et.begin();
		 	ss.save(c);
		 	et.commit();
		 addCustomer=1;
		 return addCustomer;
	}

	@Override
	@Transactional
	public int addProductDAO(Product product) {
		System.out.println(product.getDescription());
		int addCustomer=0;
		Session ss=sf.openSession();
		EntityTransaction et=ss.getTransaction();
		et.begin();
		 ss.save(product);
		et.commit();
		 addCustomer=1;
		 return addCustomer;
	}

	@Override
	public Customer customerLoginDAO(String email, String pass) {
		Customer r=null;
		Session ss=sf.openSession();
		Query q=ss.createQuery("from com.onlineshopboot.entity.Customer c where c.email=:cid AND c.password=:pid");
  		q.setParameter("cid", email);
  		q.setParameter("pid", pass);
  		List<Customer> ll=q.getResultList();
  		
  		if(ll.size()>0) {
			 r=ll.get(0);  
		 }
		return r;
	}

}
