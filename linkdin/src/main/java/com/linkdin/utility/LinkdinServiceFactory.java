package com.linkdin.utility;

import com.linkdin.service.LinkdinService;
import com.linkdin.service.LinkdinServiceInterface;

public class LinkdinServiceFactory {
	private static LinkdinServiceInterface li = null;

	private LinkdinServiceFactory() {

	}

	public static LinkdinServiceInterface createObject(String ss) {
		
		if (ss.equals("user")) {
			if (li == null) {
				li = new LinkdinService();
			}
		}

		return li;
	}

}
