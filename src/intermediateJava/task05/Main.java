package intermediateJava.task05;


public class Main {

 public static void main(String[] args) throws InterruptedException {
	 
     Thread thread1 = new Thread(new Runnable() {
         @Override
         public void run() {
             for(int i=0; i<5; i++) {
                 System.out.println("스레드1=Hello");
                 try { Thread.sleep(200); } catch (InterruptedException e) {}
             }
         }
     });

     Thread thread2 = new Thread(() -> {
         for(int i=0; i<5; i++) {
             System.out.println("스레드2=World");
             try { Thread.sleep(200); } catch (InterruptedException e) {}
         }
     });

     thread1.start();
     thread2.start();

     thread1.join();
     thread2.join();

     interface Calculator {
         int operate(int a, int b);
     }

     Calculator add = (a, b) -> a + b;
     Calculator subtract = (a, b) -> a - b;
     Calculator multiply = (a, b) -> a * b;
     Calculator divide = (a, b) -> b != 0 ? a / b : 0;

     int x = 10;
     int y = 5;

     System.out.println("람다식 계산기 결과:");
     System.out.println("10 + 5 = " + add.operate(x, y));
     System.out.println("10 - 5 = " + subtract.operate(x, y));
     System.out.println("10 * 5 = " + multiply.operate(x, y));
     System.out.println("10 / 5 = " + divide.operate(x, y));
 }
}

