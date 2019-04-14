package com.sort;

import java.util.Arrays;

public class MergeSortRefactored {
	int count = 0;
	public void mergeSort(int start, int end, int[] arr) {
		count++;
		if(start < end) {
			int middle = (start + end) / 2;
			mergeSort(start, middle, arr);
			mergeSort(middle + 1, end, arr);
			merge(start, middle, end, arr);
		}
	}

	private void merge(int start, int middle, int end, int[] arr) {
		int[] leftarr = Arrays.copyOfRange(arr, start, middle + 1);
		int[] rightarr = Arrays.copyOfRange(arr, middle + 1, end + 1);
		int o = start, l = 0, r = 0;
		count++;
		while (l < leftarr.length && r < rightarr.length) {
			if(leftarr[l] < rightarr[r]) {
				arr[o++] = leftarr[l++];
				count++;
			}
			else {
				arr[o++] = rightarr[r++];
				count++;
			}
		}
		while (l < leftarr.length) {
			arr[o++] = leftarr[l++];
			count++;
		}
		while (r < rightarr.length) {
			arr[o++] = rightarr[r++];
			count++;
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
