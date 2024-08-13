

class MyThread extends Thread{
	
	String message[]= {"I","Love","Java","!"};
	
	MyThread(String str){
		super(str);
	}
	
	public void run() {
		ThreadSync.executeMyThread(getName(),message);
	}
}

class ThreadSync{
	static synchronized void executeMyThread(String name,String msg[]) {
		for(int i=0;i<msg.length;i++) {
			try {
				Thread.sleep(2000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println(name+"    "+msg[i]);
		}
	}
}

public class ThreadSyncDemo {

	public static void main(String[] args) {
		MyThread t1=new MyThread("Thread 1 : ");
		MyThread t2=new MyThread("Thread 2 : ");
		t1.start();
		t2.start();

	}

}
