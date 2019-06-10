package com.extra.series;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class MyClass implements Runnable {

	Object lock = new Object();
	Object lock2 = new Object();
	Object lock3 = new Object();
	int id;
	volatile int n1 = 1, n2 = 2, n3 = 3, n =1;
	volatile boolean first = true, second = false, third = false;

	MyClass(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		if (id == 1)
			printFirst();
		else if (id == 2)
			printSecond();
		else
			printThird();
	}

	 void printThird() {
		synchronized (this) {
			while (true) {
				if (third) {
					System.out.println("Thread " + Thread.currentThread().getName() + "-" + n++);
					first = true;
					second = false;
					third = false;
					try {
						notifyAll();
						//System.out.println("n1 " + n1 + " id " + id + " first " + first);
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
				} /*
					 * else { notifyAll(); }
					 */
			}
		}
	}

	 void printSecond() {

		synchronized (this) {

			while (true) {
				// System.out.println("n1 "+ n1 + " id "+id+" first "+ first);
				if (second) {
					System.out.println("Thread " + Thread.currentThread().getName() + "-" + n++);
					first = false;
					second = false;
					third = true;
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				} else {
					notifyAll();
				}
				System.out.println("n1 " + n1 + " id " + id + " first " + first);
			}
		}
	}
	 
	 void first() throws InterruptedException {
		 synchronized(this) {
			 while(true) {
			 System.out.println("First Thread");
			 wait();
			 System.out.println("Resumed");
			 }
		 }
	 }
	 void third() {
		 int i = 0;
		 synchronized(this) {
			 while(true) {
			 System.out.println("Second Thread");
			 notify();
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 if(i++ == 3) {
				 break;
			 }
			 System.out.println("Finised");
			}
		 }
	 }

	 void printFirst() {
		synchronized (this) {
			while (true) {
				// System.out.println("n1 "+ n1 + " id "+id+" first "+ first);
				if (first) {
					System.out.println("Thread " + Thread.currentThread().getName() + "-" + n++);
					first = false;
					//second = true;
					second = false;
					// third = false;
					third = true;

				} else {
					notifyAll();
				}
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("n1 " + n1 + " id " + id + " first " + first);
			}
			
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

public class PrintSeries {
	public static void main(String[] args) throws InterruptedException {
		/* ExecutorService ex = Executors.newFixedThreadPool(3); */

		int i = 0, n = 1;
		MyClass obj = new MyClass(i);
		/*while (++i <= 3) {
			obj.setId(i);
			Thread t = new Thread(obj);
			t.start();
			Thread.sleep(2000);
		}*/
		Thread t = new Thread() {
			
			@Override
			public void run() {
				// obj.printFirst();
				try {
					obj.first();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
		Thread t2 = new Thread() {
			
			@Override
			public void run() {
				obj.setId(3);
				///obj.printThird();
				obj.third();
			}
		};
		t2.start();
	}
}
