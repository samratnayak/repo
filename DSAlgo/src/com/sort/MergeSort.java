package com.sort;

import java.util.Arrays;

public class MergeSort {

	int count = 0;
	public int startMergeSort(int[] arr) {
		int start = 0, end = arr.length - 1; 
		mergeSort(start, end, arr);
		return count;
	}
	private void mergeSort(int start, int end, int[] arr) {
		count++;
		if(start >= end)
			return;
		int middleIndex =  (end+start) / 2;
		mergeSort(start, middleIndex, arr);
		mergeSort(middleIndex +1 , end, arr);
		merge(start, end, middleIndex, arr);
	}
	private void merge(int start, int end, int middleIndex, int[] arr) {
		int ci = start, li = 0, ri = 0;
		int[] left = Arrays.copyOfRange(arr, start, middleIndex + 1);
		int[] right = Arrays.copyOfRange(arr, middleIndex +1 , end + 1);
		count++;
		/*System.out.println("Left : ");
		Arrays.stream(left)
				.forEach(e -> System.out.println(e+" "));
		*/// System.out.println("Right : ");
		/*Arrays.stream(right)
				.forEach(e -> System.out.println(e+" "));*/
		while(li <= (middleIndex-start) && ri < (end - middleIndex)) {
			count++;
			/*System.out.println(" middleIndex-start "+(middleIndex-start)+ " li "+li+ " ri, (end - middleIndex)  "+ri +" "+(end - middleIndex));*/
			int minVal = min(left[li], right[ri]);
			if(minVal == left[li]) {
				arr[ci] = left[li];
				li++;
			} else {
				arr[ci] = right[ri];
				ri++;
			
			}
			ci++;
		}
		while(li <= (middleIndex - start)) {
			count++;
			arr[ci++] = left[li++];
		}
		while(ri < (end - middleIndex)) {
			count++;
			arr[ci++] = right[ri++];
		}
	}
	private int min(int i, int j) {
		return i < j ? i : j;
	}
}
