package com.onlineshop.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.onlineshop.entity.Customer;
import com.onlineshop.utility.ServiceFactory;

public class CustomerServiceTest {
private CustomerServiceInterface cService;
	@Before
	public void setUp() throws Exception {
		cService=ServiceFactory.getObject("customer");
	}

	@After
	public void tearDown() throws Exception {
		cService=null;
	}

	@Test
	public void testAddCustomerService() {
		Customer c=new Customer();
		c.setName("Shalini");
		c.setAddress("Chennai");
		c.setGender("Female");
		c.setMobile("9886345721");
		c.setPassword("abcd");
		c.setPincode("560036");
		int i=cService.addCustomerService(c);
		
		assert i>0:"Customer Registration System.out.println";
		
	}

	@Test
	public void testAddProductService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testAddtoCartService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testAddOrderService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testDeleteFromCartService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testFindMaxOrderService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testFindTotalProductService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testUpdateOrderStatusService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testUpdateProductService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testAdminLoginService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testCustomerLoginService() {
		System.out.println("Not yet implemented");
	}

}
