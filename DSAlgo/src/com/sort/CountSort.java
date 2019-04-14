package com.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSort {

	public int sort(int[] arr) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for(int e : arr) {
			count++;
			if(e > max) {
				max = e;
			}
			if(map.containsKey(e))
				map.put(e, map.get(e) + 1);
			else {
				map.put(e, 1);
			}
		}
		int[] masterArr = new int[max+1];
		for(int e : map.keySet()) {
			count++;
			masterArr[e] =  map.get(e);
		}
		int j=0;
		for(int i=0; i < masterArr.length ; i++) {
			count++;
			while(masterArr[i] >= 1) {
				count++;
				arr[j++] = i;
				masterArr[i]--;
			}
		}
		/*System.out.println("master array :  ");
		Arrays.stream(masterArr)
		.forEach(e -> System.out.print(e +" ") );*/
		return count;
	}
	public int sort2(int[] arr) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for(int e : arr) {
			count++;
			if(e > max) {
				max = e;
			}
			if(map.containsKey(e))
				map.put(e, map.get(e) + 1);
			else {
				map.put(e, 1);
			}
		}
		int[] masterArr = new int[max+1];
		for(int e : map.keySet()) {
			count++;
			masterArr[e] =  masterArr[e-1] + map.get(e);
		}
		// int j=0;
		for(int i=0; i < arr.length ; i++) {
			count++;
			arr[masterArr[i]--] = i;
		}
		
		return count;
	}
}
