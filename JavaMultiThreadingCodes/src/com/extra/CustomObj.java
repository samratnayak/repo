package com.extra;

public class CustomObj {

	static synchronized void staticMethodCall() throws InterruptedException {
		System.out.println("static Method called " + Thread.currentThread().getName());
		Thread.sleep(2000);
	}

	synchronized void methodCall() throws InterruptedException {
		System.out.println("Method called " + Thread.currentThread().getName());
		Thread.sleep(4000);
	}
}
