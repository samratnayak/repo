package VolatileKeyword_2;

/**
 * Volatile Keyword, <em>â€œâ€¦ the volatile modifier guarantees that any thread that
 * reads a field will see the most recently written value.â€�</em> - Josh Bloch
 * <br><br>
 * Codes with minor comments are from
 * <a href="http://www.caveofprogramming.com/youtube/">
 * <em>http://www.caveofprogramming.com/youtube/</em>
 * </a>
 * <br>
 * also freely available at
 * <a href="https://www.udemy.com/java-multithreading/?couponCode=FREE">
 *     <em>https://www.udemy.com/java-multithreading/?couponCode=FREE</em>
 * </a>
 *
 * @author Z.B. Celik <celik.berkay@gmail.com>
 */
import java.util.Scanner;

class Processor extends Thread {

    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Running "+Thread.currentThread().getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class App {

    public static void main(String[] args) {
        Processor pro = new Processor();
        Processor pro1 = new Processor();
        pro.start();
        
       // pro1.start();
        // Wait for the enter key
        System.out.println("Enter something to stop the thread,\nVolatile variable running will be forced to true :");
        //new Scanner(System.in).nextLine();
        if(args[0].equalsIgnoreCase("stop"))
        pro.shutdown();
        //pro1.shutdown();
    }
}
