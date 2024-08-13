
import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;



public class AppletDemo extends Applet implements Runnable{
	
	Thread t;
	String str;
	
	public void init() {
		t=new Thread(this);
		str="";
		t.start();
	}
	
	
	@Override
	public void run() {
		while(true) {
			Date d=new Date();
			str=d.toString();
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			repaint();
			
		}
		
	}
	
	
	public void paint(Graphics g) {
		g.drawString(str, 100, 100);
	}

	
}
