package com.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("b1")
public class Trainee {
	@Autowired
	private TrainerInterface ti;
	@Autowired
	private LibraryInterface li;
	@Autowired
	private CanteenInterface ci;
	
	
	public void execute() {
		ti.teach();
		li.isuueBooks();
		ci.serveFood();
	}

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("abc.xml");
				
		
		Trainee tt=(Trainee)ctx.getBean("b1");
		
		//TrainerInterface t2=new Trainer();
		//tt.setTi(t2);   //injecting object of trainer inside setter method is known as dependency injection
		
		tt.execute();

	}

}







