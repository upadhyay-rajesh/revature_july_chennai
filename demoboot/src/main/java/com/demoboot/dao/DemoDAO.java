package com.demoboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demoboot.entity.Customer;

@Repository
public class DemoDAO implements DemoDAOInterface{

	@Autowired
	private SessionFactory sf;
	
	@Autowired
	private EntityManagerFactory emf;
	
	@Override
	
	public int createProfile(Customer c) {
		Session ss=sf.openSession();  //for hibernate
		//EntityManager em=emf.createEntityManager(); //for JPA
		
		EntityTransaction et=ss.getTransaction();
		et.begin();
		
		ss.save(c);// FOR HIBERNATE
		
		//em.persist(c); //for JPA
		et.commit();
		
		return 1;
	}

	@Override
	public int loginProfile(Customer c) {
		int i=0;
		Session ss=sf.openSession(); 
		
		Query q1=ss.createNativeQuery("");
		
		Query q2=ss.createCriteria(Customer.class);
		
		Query q=ss.createNamedQuery("findallcustomer");
		q.setParameter("myemail", c.getEmail());
		q.setParameter("pwd", c.getPassword());
		
		List<Customer> ll=q.getResultList();
		if(ll.size()>0) {
			i=1;
		}
		return i;
	}

	@Override
	public List<Customer> displayAllProfile() {
		Session ss=sf.openSession(); 
		Query q=ss.createQuery("from com.demoboot.entity.Customer c");
		List<Customer> ll=q.getResultList();
		return ll;
	}

}






