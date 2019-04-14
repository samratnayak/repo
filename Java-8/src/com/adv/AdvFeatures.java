package com.adv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Date;
import java.lang.System;

public class AdvFeatures {

	private static long changeCase() {
		return 5;
	}
	public static  void main(String[] args){
		testList();
		testMap();
	}
	private static void testMap() {
		Map<String, String> map = new HashMap<>();
		for(int i=1; i< 21; i++) {
			map.put(""+i, "value"+i);
		}
		System.out.println("map "+map);
		boolean res = map.keySet().stream().anyMatch(e -> e.equals("9"));
		map.forEach((k,v)-> {
			if(k.equals("9")) {
				k = k+"c";
			}
			});
		System.out.println("res "+res +" new map "+map);
	}
	private static void testList() {

		List<String> list1 = new ArrayList<String>();
		for(int i=1; i<=20 ; i++){
			list1.add("str"+i);
		}
		list1.add("");
		System.out.println("str "+list1);
		List<String> t = list1.stream().
				limit(changeCase()).collect(Collectors.toList());
		System.out.println("t "+t);
	
	}
}
