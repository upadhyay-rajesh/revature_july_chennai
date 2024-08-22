package com.revshop.utility;

import com.revshop.service.GlobalService;
import com.revshop.service.GlobalServiceInterface;

public class RevShopServiceFactory {

	public static GlobalServiceInterface createObject(String serviceType) {
		if(serviceType.equals("global")) {
			return new GlobalService();
		}
		return null;
	}

}
