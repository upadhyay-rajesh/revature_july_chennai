
public class ThreadDemo {

	public static void main(String[] args) {
		Thread t=Thread.currentThread();
		System.out.println(t);
		
		t.setName("Revature thread");
		System.out.println(t);

	}

}
