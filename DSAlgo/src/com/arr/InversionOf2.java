package com.arr;

import java.util.Arrays;

public class InversionOf2 {

	static int inversionCount = 0;

	public static void main(String[] args) {
		// https://www.lynda.com/Docker-tutorials/Manage-containers/721901/779048-4.html?org=oracle.com
		// unsorted array
		//int a[] = { 5, 6, 9, 3, 19, 2, 18 };
		int a[] = { 15, 21, 25, 8, 11};
		System.out.println("Array before " + Arrays.toString(a));
		enhancedMerge(a, 0, a.length - 1);
		System.out.println("inversion count " + inversionCount);
		System.out.println("Array " + Arrays.toString(a));
		int res = 5 & -5;
		int num = 6;
		while (num > 0) {
			num = num >> 1;
			System.out.println("");
			displayNumBinary(num);
		}
		displayNumBinary(num);
		System.out.println("\nbinary of -5");
		//displayNumBinary(-5);
		System.out.println(" -1 :"+ Integer.toBinaryString(( -7 & 7))+" len "+Integer.toBinaryString(-3));
		System.out.println("\nres " + res);
	}

	private static void displayNumBinary(int num) {
		System.out.println("called : "+ Integer.toBinaryString(num));
		if(num == 0) {
			return;
		}
		displayNumBinary(num >> 1);
		int res = num & 1;
		System.out.println("num = "+num+" res "+res);
	}

	private static void enhancedMerge(int[] a, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			enhancedMerge(a, start, mid);
			enhancedMerge(a, mid + 1, end);
			merge(a, start, mid, end);
		}
	}

	private static void merge(int[] a, int start, int mid, int end) {
		int left[] = Arrays.copyOfRange(a, start, mid + 1);
		int right[] = Arrays.copyOfRange(a, mid + 1, end + 1);
		int index = start;
		int li = 0, ri = 0;
		while (li < left.length && ri < right.length) {
			if (left[li] < right[ri]) {
				a[index] = left[li];
				li++;
			} else {
				inversionCount = inversionCount + (left.length - li);
				a[index] = right[ri];
				ri++;
			}
			index++;
		}
		while (li < left.length) {
			a[index++] = left[li++];
		}
		while (ri < right.length) {
			a[index++] = right[ri++];
		}
	}

}
