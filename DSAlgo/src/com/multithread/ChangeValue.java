package com.multithread;

public class ChangeValue {

	int v = 1;
	// Object lock = new Object();

	public /*synchronized*/ void changeVal() throws InterruptedException {
		// while(true)
		// synchronized (lock) {
		
		/* while(v % 3 != Integer.parseInt(Thread.currentThread().getName())) {
		 lock.wait(); }*/
		 
		for (int i = 0; i < 1000; i++) {
			v += 1;
		}
		System.out.println(Thread.currentThread().getId()+". val " + v);
		// lock.notifyAll();
		// }
	}

	public static void main(String[] args) {
		ChangeValue cv = new ChangeValue();
		for (int i = 1; i < 4; i++) {
			Runnable r = () -> {
				try {
					cv.changeVal();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
			Thread t = new Thread(r, "" + (i - 1));
			t.start();
		}
	}

}
