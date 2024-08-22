package com.revshop.utility;

import com.revshop.dao.GlobalDAO;
import com.revshop.dao.GlobalDAOInterface;


public class RevShopDAOFactory {

	public static GlobalDAOInterface createObject(String daoType) {
		if(daoType.equals("global")) {
			return new GlobalDAO();
		}
		return null;
	}

}
