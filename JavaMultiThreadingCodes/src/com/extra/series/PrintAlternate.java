package com.extra.series;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class T extends Thread{
	int id;
	static boolean f = true, s = false, t = false; 
	static int num = 0;
	Lock lock = new ReentrantLock();
	Condition cond = lock.newCondition();
	T(int id){this.id = id;}
	@Override
	public void run() {
		while(true) {
			if(id == 1) {
				lock.tryLock();
				if(f) {
					System.out.println(id+" "+(++num)+" ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					f = false;
					s = true;
					t = false;
					cond.signalAll();
				} else {
					 lock.unlock();
				}
			}
			
			if(id == 2) {
				lock.tryLock();
				if(s) {
					System.out.println(id+" "+(++num)+" ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					f = false;
					s = false;
					t = true;
					cond.signalAll();
				} else {
					lock.unlock();
				}
			}
			
			if(id == 3) {
				lock.tryLock();
				if(t) {
					System.out.println(id+" "+(++num)+" ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					f = true;
					s = false;
					t = false;
					cond.signalAll();
				} else {
					lock.unlock();
				}
			}
		}
	}
}
public class PrintAlternate {
	public static void main(String[] args) {
		T ob1 = new T(1);
		T ob2 = new T(2);
		T ob3 = new T(3);
		System.out.println(ob1.lock);
		System.out.println(ob2.lock);
		System.out.println(ob3.lock);
		Thread t1 = new Thread(ob1);
		Thread t2 = new Thread(ob2);
		Thread t3 = new Thread(ob3);
		t1.start();
		t2.start();
		t3.start();
	}
}
