package com.springcore;

import org.springframework.stereotype.Component;

@Component("d1")
public class Canteen implements CanteenInterface{
	public void serveFood() {
		System.out.println("food served");
	}
}
