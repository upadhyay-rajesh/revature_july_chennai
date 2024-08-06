package com.linkdin.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.linkdin.entity.LinkdinUser;
import com.linkdin.utility.LinkdinServiceFactory;

public class LinkdinServiceTest {
	
	private LinkdinServiceInterface ls;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ls=LinkdinServiceFactory.createObject("user");
	}

	@After
	public void tearDown() throws Exception {
		ls=null;
	}

	@Test
	public void testCreateProfileService() {
		
		LinkdinUser lu=new LinkdinUser();
		lu.setName("mm");
		lu.setPassword("mmmmm");
		lu.setEmail("mm@gmail.com");
		lu.setAddress("Ahemedabad");
		
		int i=ls.createProfileService(lu);
		
		assert i>0 : "profile not created";
	}

	@Test
	public void testViewProfileService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testViewAllProfileService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testEditProfileService() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testDeleteProfileService() {
		System.out.println("Not yet implemented");
	}

}
