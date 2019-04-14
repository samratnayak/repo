package com.basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*		Set<String> values = new HashSet<>();
		values.add("ABC");
		values.add("DEF");
		values.add("ABC");
		values.add("DEF");
		
		//old style
		Iterator<String> it = values.iterator();
		while(it.hasNext()) {
			String val = it.next();
			if(values.equals("ABC"))
			System.out.println(val);
		}
		
		//new style
		values.stream()
			.filter(val -> val.equals("ABC"))
			.forEach(System.out::println);*/
		jsonUtilsDemo();
		Runnable r =  () -> System.out.println("Demo");
		new Thread(r).start();
	}

	private static void jsonUtilsDemo() {
		
	}

}
