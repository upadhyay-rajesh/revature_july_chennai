package com.onlineshop.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.onlineshop.entity.Customer;
import com.onlineshop.utility.DaoFactory;

public class CustomerDAOTest {
private CustomerDAOInterface cDAO;
	@Before
	public void setUp() throws Exception {
		cDAO=DaoFactory.getObject("customer");
	}

	@After
	public void tearDown() throws Exception {
		cDAO=null;
	}

	@Test
	public void testAddCustomerDAO() {
		Customer c=new Customer();
		c.setName("Shalini");
		c.setAddress("Chennai");
		c.setGender("Female");
		c.setMobile("9886345721");
		c.setPassword("abcd");
		c.setPincode("560036");
		int i=cDAO.addCustomerDAO(c);
		
		assert i>0:"Customer Registration System.out.println";
	}

	@Test
	public void testAddProductDAO() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testAddtoCartDAO() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testAddOrderDAO() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testDeleteFromCartDAO() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testFindMaxOrderDAO() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testFindTotalProductDAO() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testUpdateOrderStatusDAO() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testUpdateProductDAO() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testAdminLoginDAO() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testCustomerLoginDAO() {
		System.out.println("Not yet implemented");
	}

}
