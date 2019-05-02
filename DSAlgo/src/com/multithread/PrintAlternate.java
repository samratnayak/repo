package com.multithread;

public class PrintAlternate {
	
	static Object lock =  new Object();
	static int num = 1;
	
	static void printAlternate() throws InterruptedException {
		while(true)
		synchronized (lock) {
			while(!Thread.currentThread().getName().contains(""+num)) {
				lock.wait();
			}
			System.out.println(Thread.currentThread().getName()+":"+num);
			Thread.sleep(500);
			if(Thread.currentThread().getName().contains("1")) {
				num = 2;
			} else if (Thread.currentThread().getName().contains("2")) {
				num = 3;
			} else {
				num = 1;
			}
			lock.notifyAll();
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(() ->   {
			try {
				printAlternate();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Thread-1");
		t1.start();
		Thread t2 = new Thread(() ->   {
			try {
				printAlternate();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Thread-2");
		t2.start();
		Thread t3 = new Thread(() ->   {
			try {
				printAlternate();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Thread-3");;
		t3.start();
	}

}
