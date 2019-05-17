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
		useThenCombine();
		
		// https://www.callicoder.com/java-8-completablefuture-tutorial/
	}

	private static void useThenCombine() throws InterruptedException, ExecutionException {
		CompletableFuture<Double> wInkgFuture = CompletableFuture.supplyAsync(() -> {
			sleep(1000);
			return 70d;
		});
		
		CompletableFuture<Double> hInCmFuture = CompletableFuture.supplyAsync(() -> {
			sleep(1000);
			return 170d;
		});
		
		CompletableFuture<Double> bmi = hInCmFuture.thenCombineAsync(wInkgFuture, (h, w) -> (h * 10)/w);
		System.out.println("BMI using then combine "+ bmi.get());
		
	}

	private static void useThenCompose() throws InterruptedException, ExecutionException {
		CompletableFuture<String> findPerson = CompletableFuture.supplyAsync(() -> {
			sleep(1000);
			return String.valueOf("Jon");
		});
		// then apply does not flatten
		CompletableFuture<CompletableFuture<Double>> weightUsingApply =
		findPerson.thenApply(name -> findWeight(name));
		System.out.println("weight apply " + weightUsingApply.get().get());
		
		// flattened res using thencompose
		CompletableFuture<Double> weightUsingCompose =
				findPerson.thenCompose(name -> findWeight(name));
		System.out.println("weight compose " + weightUsingCompose.get());
	}

	private static CompletableFuture<Double> findWeight(String name){
		return CompletableFuture.supplyAsync(() -> {
				sleep(1000);
				double w = name.equals("Jon") ? Double.valueOf("70") : 75;
				return w;
			});
	}
	
	private static void sleep(long milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
