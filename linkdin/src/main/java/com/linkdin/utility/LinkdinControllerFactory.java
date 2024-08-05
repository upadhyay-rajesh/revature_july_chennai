package com.linkdin.utility;

import com.linkdin.controller.LinkdinController;
import com.linkdin.controller.LinkdinControllerInterface;

public class LinkdinControllerFactory {
	private LinkdinControllerFactory() {}
	
	public static LinkdinControllerInterface createObject(String n) {
		if(n.equals("user")) {
			return new LinkdinController();
					
		}
		return null;
	}
}
