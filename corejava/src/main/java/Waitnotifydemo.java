
class A extends Thread{
	Shared s;
	A(Shared s,String ss){
		super(ss);
		this.s=s;
	}
	void changeValue() {
		s.i=2;
		notify();
	}
}

class B extends Thread{
	
	Shared s;
	B(Shared s,String ss){
		super(ss);
		this.s=s;
		
		
	}
	int getValue() {
		try{
			wait();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s.i;
	}
}

class Shared{
	static int i=1;
	Shared(){
		
	}
}

public class Waitnotifydemo {

	public static void main(String[] args) {
		A a=new A(new Shared(),"Thread A");
		B b=new B(new Shared(),"Thread B");
		b.getValue();
		a.changeValue();
	}

}










