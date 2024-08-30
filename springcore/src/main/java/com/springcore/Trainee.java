package com.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Trainee {
	private TrainerInterface ti;
	private LibraryInterface li;
	private CanteenInterface ci;
	
	
	
	//adapter
	public void setLi(LibraryInterface li) {
		this.li = li;
	}

	//adapter
	public void setCi(CanteenInterface ci) {
		this.ci = ci;
	}


	//adapter
	public void setTi(TrainerInterface ti) {
		this.ti = ti;
	}

	
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







