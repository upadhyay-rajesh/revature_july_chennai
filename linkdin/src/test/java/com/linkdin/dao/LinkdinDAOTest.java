package com.linkdin.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linkdin.entity.LinkdinUser;

public class LinkdinDAOTest {

	private LinkdinDAOInterface ldao;
	
	@Before
	public void setUp() throws Exception {
		ldao=new LinkdinDAO();
	}

	@After
	public void tearDown() throws Exception {
		ldao=null;
	}

	@Test
	public void testCreateProfileDAO() {
		LinkdinUser lu=new LinkdinUser();
		lu.setName("Kalyani");
		lu.setPassword("kkkkk");
		lu.setEmail("kk@gmail.com");
		lu.setAddress("Benguluru");
		
		int i=ldao.createProfileDAO(lu);
		assert i>0 : "could not create profile";
	}

	@Test
	public void testViewProfileDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewAllProfileDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditProfileDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteProfileDAO() {
		fail("Not yet implemented");
	}

}
