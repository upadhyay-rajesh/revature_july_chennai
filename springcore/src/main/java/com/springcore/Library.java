package com.springcore;

import org.springframework.stereotype.Component;

@Component("c1")
public class Library implements LibraryInterface{
	public void isuueBooks() {
		System.out.println("book issued");
	}
}
