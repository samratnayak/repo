package core.java;

public class RunningClass extends Thread implements Runnable {
	public void run () {
		for(int i=0; i<3; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		
		}
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
public static void main(String args[]) throws ClassNotFoundException {
	Thread t = new RunningClass();
	Class.forName("java.lang.SecurityException");
	t.setName("My thread1");
	t.setPriority(5);
	t.start();
	Thread t2 = new RunningClass();
	t2.setName("My thread2");
	t2.setPriority(1);
	t2.start();
}
}
