package com.arr;

import java.util.Arrays;

public class KthHighestInNsortedArrays {

	public static void main(String[] args) {
		int[] 	a1 = {2, 8, 10, 59, 60},
				a2 = {5, 17, 34, 99, 253},
				a3 = {1, 6, 9, 18, 20 , 25},
				a4 = { 45, 47, 78, 84, 98};
		int k = 2;
		findKthHighestInNsorted(k, a1, a2, a3, a4);
		// int i = findIndexUsingBinarySearch(a1, 299, 0, a1.length - 1);
		// System.out.println(i);
		System.out.println(Arrays.toString(Arrays.copyOfRange(a1, 0, 0)));
		
	}

	private static void findKthHighestInNsorted(int k, int[] ...an) {
		if(an.length == 0) {
			return;
		}
		int low = findFirstNonEmptyArr(an), high = an[low].length;
		int mid =  low + (high - low)/2;
		int midEL = an[low][mid];
		// there are mid- 1 elements less than arr[mid]
		int smallCount = mid - 1;
		int[] indexThresHold = new int[an.length];
		indexThresHold[low] = smallCount;
		for(int i = low + 1; i < an.length; i++) {
			int arr_i[] = an[i];
			if (arr_i.length > 0) {
				int index = findIndexUsingBinarySearch(arr_i, midEL, 0, arr_i.length);
				int smallCountLocal = arr_i[index] != midEL ? (index - low) : index - low - 1;
				smallCount += smallCountLocal;
				indexThresHold[i] = smallCountLocal;
			}
		}
		if(k == smallCount + 1) {
			System.out.println("found .. "+midEL);
		}
		else if(k < smallCount + 1) {
			int newArr[][] = new int[an.length][];
			for(int i = low; i < an.length; i++) {
				newArr[i] = Arrays.copyOfRange(an[i], 0, indexThresHold[i]);
			}
			findKthHighestInNsorted(k , newArr);
		} else {
			int newArr[][] = new int[an.length][];
			System.out.println("new arr "+ Arrays.toString(newArr));
			System.out.println(" indexThresHold "+Arrays.toString(indexThresHold));
			for(int i = low; i < an.length; i++) {
				System.out.println("an[i] "+Arrays.toString(an[i])+" indexThresHold[i] - 1 "+ (indexThresHold[i] - 1)+" an[i].length - indexThresHold[i] - 1 "+(an[i].length - indexThresHold[i] - 1));
				newArr[i] = Arrays.copyOfRange(an[i], indexThresHold[i] - 1, an[i].length - indexThresHold[i] - 1);
			}
			findKthHighestInNsorted(k - smallCount , newArr);
		}
	}

	private static int findFirstNonEmptyArr(int[][] an) {
		int i = 0;
		while(an[i].length == 0) {
			i++;
		}
		return i;
	}

	private static int findIndexUsingBinarySearch(int[] arr, int key, int low, int high) {
		while(low <= high) {
			int mid = low + (high - low) /2;
			if(key == arr[mid]) {
				return mid;
			} else if(key > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return high < 0 ? low : high;
	}

}
