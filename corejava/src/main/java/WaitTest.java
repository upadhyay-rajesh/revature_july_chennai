class Market {

   private int item = 0;

   public synchronized void get() {
       //here we use wait() method
       while (item < 1) {
           try {
               wait();
           }
           catch (InterruptedException e) {
           }
       }
       item--;
       System.out.println("A client has bought 1 item...");
       System.out.println("Items quantity in Market warehouse... " + item);
       notify();
   }

   public synchronized void put() {
       //here we use wait() method when the Warehouse is full
       while (item >= 6) {
           try {
               wait();
           }
           catch (InterruptedException e) {
           }
       }
       item ++;
       System.out.println("Manufacturer has added 1 more item...");
       System.out.println("Now there are " + item + " items in Warehouse" );
       notify();
   }
}

class Manufacturer implements Runnable {

   Market market;

   Manufacturer(Market market) {
       this.market = market;
   }


   public void run() {
       for (int i = 0; i < 8; i++) {
           market.put();
       }
   }
}

class Client implements Runnable {

   Market market;
   Client(Market market) {
       this.market = market;
   }
   public void run() {
       for (int i = 0; i < 8; i++) {
           market.get();
       }
   }
}

public class WaitTest {
   public static void main(String[] args) {

       Market market = new Market();
       Manufacturer manufacturer = new Manufacturer(market);
       Client client = new Client(market);
       new Thread(manufacturer).start();
       new Thread(client).start();
   }
}












