package com.sort;

public class InsertionSort {

	public int insertionSort(int[] arr) {
		int count = 0;
		for(int i=1; i < arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			while(j >= 0 && key < arr[j]) {
				count++;
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		return count;
	}
}
