package com.corejava.java8;


//what is functional interface
//interface with exactly  one abstract method is known as functional interface
@FunctionalInterface
public interface FunctionalInterfaceDemo {
	void add();
	default void multiplication() {
		
	}
	static void divisio() {
		
	}
}

class Main {
	public void calculate() {
		System.out.println("Result is "+(8+9));
	}
	
	public void sayHello() {
		System.out.println("hello");
	}
	public static void main(String arg[]) {
		FunctionalInterfaceDemo f1= new Main()::calculate; //method referencing here add method is refering to calculate
		f1.add();
		FunctionalInterfaceDemo f2=new Main()::sayHello;
		f2.add();
	}
}









