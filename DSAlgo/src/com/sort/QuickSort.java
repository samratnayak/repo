package com.sort;

import java.util.Arrays;

public class QuickSort {
	int count = 0;

	public static void main(String[] args) {
		int[] arr = { 10, 23, 45, 60, 2, 10, 20, 30, 1 };
		new QuickSort().quickSort(arr, 0, arr.length - 1);
		Arrays.stream(arr)
			.mapToObj( e -> new Integer(e))
			.forEach(System.out :: println);
	}

	public int quickSort(int[] arr, int low, int high) {
		count++;
		if (high > low) {
			int i_pivot = pivot(arr, low, high);
			quickSort(arr, low, i_pivot -1);
			quickSort(arr, i_pivot + 1, high);
		}
		return count;
	}

	private int pivot(int[] arr, int low, int high) {
		int pivot = arr[high], i = low - 1;
		for(int j = low; j < high; j++) {
			count++;
			if(arr[j] < pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		arr[high] = arr[i+1];
		arr[i +1] = pivot;
		return i + 1;
	}

	private void swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}
}
