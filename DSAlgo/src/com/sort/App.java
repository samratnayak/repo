package com.sort;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		int[] arr =  // new int[] {4, 35, 90, 8, 35, 101, 8, 90, 8};
				new int[]{89, 34, 201, 2, 34, 76, 100, 50, 43, 30, 23, 10, 15, 27, 98, 345, 58, 99,
				89, 34, 201, 2, 34, 76, 100, 50, 43, 30, 23, 10, 15, 27, 98, 345, 58, 99,
				87, 35, 20, 1, 33, 75, 101, 56, 44, 31, 22, 9, 14, 25, 97, 346, 59, 90, 3488};
		Arrays.stream(arr)
			  .forEach(e -> System.out.print(e + " "));
		MergeSortRefactored object = new MergeSortRefactored();
		// object.mergeSort(0, arr.length-1, arr);
		int count = 
				 // new MergeSort().startMergeSort(arr);
				// object.getCount();
				// new InsertionSort().insertionSort(arr);
				// new SelSort().selSort(arr);
				 // new CountSort().sort(arr);
				 new QuickSort().quickSort(arr, 0, arr.length - 1);
		System.out.println("\nFinal count :"+count+"\n");
		Arrays.stream(arr)
			  .forEach(e -> System.out.print(e + " "));
	}
}
