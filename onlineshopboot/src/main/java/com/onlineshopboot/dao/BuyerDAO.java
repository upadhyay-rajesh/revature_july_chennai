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
import com.onlineshopboot.entity.ShopingCart;

@Repository
@Transactional
public class BuyerDAO implements BuyerDAOInterface{

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
	public int findMaxOrderDAO() {
		int r=0;
		Session ss=sf.openSession();
		 
		Query q=ss.createQuery("select max(s.order_no) from com.onlineshopboot.entity.Orders s");
		r=q.getFirstResult();
		System.out.println("max order is "+r);
		//q.getResultList();
		
		return r;
	}

	@Override
	public List<Object> findTotalProductDAO(Object attribute, int order_no) {
		Session ss=sf.openSession();
		Query q=ss.createQuery("select tp.image_name,tp.name,tc.quantity,tc.mrp_price,tc.discount_price,tc.total_price,tc.product_id from com.onlineshopboot.entity.Product tp,com.onlineshopboot.entity.ShopingCart tc where tp.id=tc.product_id and tc.customer_id=:cid");
		q.setParameter("cid", attribute);
		List<Object> ll=q.getResultList();
		return ll;
	}

	@Override
	public int addOrderDAO(Orders order) {
		int addCustomer=0;
		Session ss=sf.openSession();
		EntityTransaction et=ss.getTransaction();
		et.begin();
		 ss.save(order);
		 et.commit();
		 addCustomer=1;
		 return addCustomer;
	}

	@Override
	public void deleteFromCartDAO(Object attribute) {
		Session ss=sf.openSession();
		EntityTransaction et=ss.getTransaction();
		et.begin();
		Query q=ss.createQuery("delete from com.onlineshopboot.entity.ShopingCart s where s.customer_id=:cid");
		q.setParameter("cid", attribute);
		
		q.executeUpdate();
		et.commit();
	}

	@Override
	public int addtoCartDAO(ShopingCart sCart) {
		int addCustomer=0;
		Session ss=sf.openSession();
		EntityTransaction et=ss.getTransaction();
		et.begin();
		 ss.save(sCart);
		 et.commit();
		 addCustomer=1;
		 return addCustomer;
	}

	@Override
	public int updateProductDAO(String attribute, int productId, int quantity) {
		int i=0;
		String discount_price=null;
		double productPrice=0;
		Session ss=sf.openSession();
		EntityTransaction et=ss.getTransaction();
		et.begin();
		Query q=ss.createQuery("from com.onlineshopboot.entity.ShopingCart s where s.customer_id=:cid and s.product_id=:pid");
 		q.setParameter("cid", attribute);
 		q.setParameter("pid", productId);
 		List<ShopingCart> ll=q.getResultList();
 		
 		for(ShopingCart ss2:ll) {
 			
 			 discount_price = ss2.getDiscount_price();
             //Converting into double from string
             productPrice = Double.parseDouble(discount_price);
 		}
 		productPrice = productPrice * quantity;
 	
 				 Query q1=ss.createQuery("update com.onlineshopboot.entity.ShopingCart s set s.quantity=:qt,s.total_price=:tp where s.customer_id=:cid and s.product_id=:pid");
 		    		q1.setParameter("qt", quantity);
 		    		q1.setParameter("tp", productPrice);
 		    		q1.setParameter("cid", attribute);
 		    		q1.setParameter("pid", productId);
	                	
	       			 	i=q1.executeUpdate();
	       			 et.commit();
	       			 	return i;
	}

}
