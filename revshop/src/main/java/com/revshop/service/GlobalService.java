package com.revshop.service;

import com.revshop.dao.GlobalDAOInterface;
import com.revshop.entity.Buyer;
import com.revshop.utility.RevShopDAOFactory;

public class GlobalService implements GlobalServiceInterface {

	@Override
	public Buyer signinService(Buyer user) {
		GlobalDAOInterface gDao=RevShopDAOFactory.createObject("global");
		
		return gDao.signInDAO(user);
	}

}
