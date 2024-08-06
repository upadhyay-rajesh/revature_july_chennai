package com.linkdin.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.linkdin.entity.LinkdinUser;
import com.linkdin.utility.LinkdinControllerFactory;

public class LinkdinControllerTest {
	
	private LinkdinControllerInterface lc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("loading global resource");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("unloading global resource");
	}

	@Before
	public void setUp() throws Exception {
		lc=LinkdinControllerFactory.createObject("user");
	}

	@After
	public void tearDown() throws Exception {
		lc=null;
	}

	@Test
	public void testCreateProfileController() {
		lc.createProfileController();
	}

	@Test
	public void testViewProfileController() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testViewAllProfileController() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testEditProfileController() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testDeleteProfileController() {
		System.out.println("Not yet implemented");
	}

}
