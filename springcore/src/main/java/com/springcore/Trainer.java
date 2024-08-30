package com.springcore;

import org.springframework.stereotype.Component;

@Component("a1")
public class Trainer implements TrainerInterface{
	public void teach() {
		System.out.println("trainer is teaching");
	}
}
