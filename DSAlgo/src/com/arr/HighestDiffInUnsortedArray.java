package com.arr;

public class HighestDiffInUnsortedArray {

	/**
	 * 
	 * The diff must be a[j] - a[i] where j > i and ar[j] > a[i]
	 * Find the highest among those
	 */
	
	public static void main(String[] args) {
		// unsorted arr
		int a [] = //{5, 9, 4, 10, 43, 1, 41};
		{43, 41, 10, 9, 5, 4, 1};
		for(int i = 0; i < a.length; i++)
			a[i] = a[i];
		findMaxDiff(a);
	}

	private static void findMaxDiff(int[] a) {
		int min = a[0], maxDiff = -1;
		for(int i = 1; i < a.length; i++) {
			int currDiff = a[i] - min;
			if(currDiff > maxDiff && currDiff >= 0) {
				maxDiff = currDiff;
			}
			if(a[i] < min)
				min = a[i];
		}
		System.out.println("max diff "+ maxDiff);
	}

}
