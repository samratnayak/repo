package com.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureUsage {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long startTime = System.currentTimeMillis();
		CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
			System.out.println("Runing async..pause..");
			sleep(1000);
			System.out.println("Runing async..resumed");

		});
		
		f1.get();
		long timeRunAsync = System.currentTimeMillis();
		// supply
		CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
			System.out.println("in f2");
			return "welcome";
		});

		// runs after f2
		CompletableFuture<String> f3 = f2.thenApplyAsync(val -> {
			sleep(1000);
			System.out.println("in f3");
			return val + " to";
		});
		
		// runs after f3
		CompletableFuture<Void> f4 = f3.thenAcceptAsync(val -> {
			sleep(1500);
			System.out.println("in f4");
			System.out.println(val + " FUTURE");
		});
		// block current thread and obtain result 
		//f4.get();
		f4.thenRunAsync(() -> System.out.println("Execution over")).get();
		long timeAcceptAndapply = System.currentTimeMillis();
		System.out.println("Time taken run ansync " + (timeRunAsync - startTime) + " and apply, accept, run "
				+ (timeAcceptAndapply - timeRunAsync));
		// flatten result using then compose
		useThenCompose();
		
		// combine 2 independent futures and do something with result
		// https://www.callicoder.com/java-8-completablefuture-tutorial/
	}

	private static void useThenCompose() {
		CompletableFuture<Double> findHeight = CompletableFuture.supplyAsync(() -> {
			sleep(1000);
			return Double.valueOf("171");
		});
		CompletableFuture<Double> findWeight = CompletableFuture.supplyAsync(() -> {
			sleep(1000);
			return Double.valueOf("70");
		});
		findHeight.thenApply(d -> d/2);
	}

	private static void sleep(long milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
