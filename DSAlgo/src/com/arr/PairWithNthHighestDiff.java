package com.arr;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;


public class PairWithNthHighestDiff {

	public static void main(String[] args) {
		int[] arr = {6, -1, 9, 3, 19, 20, 33, 35}; // {-1, 3, 9, 19, 20, 33, 35}
		findAllDIff(arr);
		int k = 3;
		int d = findKthhighestDiff(arr, k);
		System.out.println("k = "+k+" diff "+ d);
	}

	private static void findAllDIff(int[] arr) {
		int n = arr.length;
		int[] diffArr = new int[(n * (n - 1)) / 2];
		int f_i = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i +1; j < arr.length; j++) {
				diffArr[f_i++] = Math.abs(arr[i] - arr[j]);
			}
		}
		Arrays.sort(diffArr);
		System.out.println(Arrays.toString(diffArr));
	}

	private static int findKthhighestDiff(int[] arr, int k) {
		PriorityQueue<Integer> pqKsmall = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pqKlarge = new PriorityQueue<>();
		for(int i = 0; i < arr.length; i++) {
			if(pqKsmall.isEmpty()) {
				pqKsmall.add(arr[i]);
			}
			if(pqKlarge.isEmpty()) {
				pqKlarge.add(arr[i]);
			}
			int smallestsoFar = pqKsmall.peek();
			if(arr[i] < smallestsoFar) {
				if(pqKsmall.size() == k)
					pqKsmall.remove();
				pqKsmall.add(arr[i]);
			}
			int highestSoFar = pqKlarge.peek();
			if(arr[i] > highestSoFar) {
				if(pqKlarge.size() == k)
					pqKlarge.remove();
				pqKlarge.add(arr[i]);
			}
		}
		PriorityQueue<Integer> pqKsmallFinal = new PriorityQueue<>();
		while(!pqKsmall.isEmpty()) {
			pqKsmallFinal.add(pqKsmall.poll());
		}
		System.out.println("pqKsmall "+ pqKsmall+" pk small final "+ pqKsmallFinal +" pk large "+ pqKlarge);
		List<Integer> arr1 = pqKsmallFinal.stream().collect(Collectors.toList());
		List<Integer> arr2 = pqKlarge.stream().collect(Collectors.toList());
		PriorityQueue<Integer> ansPq = new PriorityQueue<>();
		System.out.println("arr1 "+ arr1+" arr2 "+ arr2);
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < k; j++) {
				int diff  = Math.abs(arr1.get(i) - arr2.get(j));
				if(ansPq.size() < k) {
					ansPq.add(diff);
				} else {
					int currLow = ansPq.peek();
					if(diff > currLow) {
						ansPq.remove();
						ansPq.add(diff);
					}
				}
			}
		}
		return ansPq.peek();
	}

}
