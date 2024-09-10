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
import com.onlineshopboot.entity.Orders;

@Repository
@Transactional
public class AdminDAO implements AdminDAOInterface{
	
	@Autowired
	private SessionFactory sf;

	@Override
	
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
	public int updateOrderStatusDAO(String orderId) {
		int i=0;
		Session ss=sf.openSession();
		EntityTransaction et=ss.getTransaction();
		et.begin();
		Query q=ss.createQuery("from com.onlineshopboot.entity.Orders oo where oo.order_no=:oid");
		q.setParameter("oid", orderId);
		List<Orders> ll=q.getResultList();
		if(ll.size()>0) {
			 if (ll.get(0).getOrder_status().equals("Deliver")) {
				 Query q1=ss.createQuery("update com.onlineshopboot.entity.Orders oo set oo.order_status='Pending' where oo.order_no=:oid");
		    		q1.setParameter("oid", orderId);
                	
       			 	i=q1.executeUpdate();
                    } else {
                    	Query q2=ss.createQuery("update com.onlineshopboot.entity.Orders oo set oo.order_status='Deliver' where oo.order_no=:oid");
        	    		q2.setParameter("oid", orderId);
                	
       			 	i=q2.executeUpdate();
                    }
		}
		et.commit();
		return i;
	}

	@Override
	public String adminLoginDAO(String email, String password) {
		String r=null;
		Session ss=sf.openSession();
		Query q=ss.createQuery("from com.onlineshopboot.entity.Customer c where c.email =:cid AND c.password =:pid");
  		q.setParameter("cid", email);
  		q.setParameter("pid", password);
  		List<Customer> ll=q.getResultList();
  		
  		if(ll.size()>0) {
			 r=ll.get(0).getName();  
		 }
		return r;
	}

}
