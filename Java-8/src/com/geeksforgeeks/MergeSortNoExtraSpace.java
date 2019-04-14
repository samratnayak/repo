package com.geeksforgeeks;

public class MergeSortNoExtraSpace {

	public static void main(String[] args) {

		int a[] = {1, 9, 12, 19, 21};
		int b[] = {2, 7, 8, 10, 17};
		mergeSortedArr(a, b);
		System.out.println("a ..\n");
		displayArr(a);
		System.out.println("\nb ..\n");
		displayArr(b);
	}

	private static void displayArr(int[] a) {

		for(int e : a) {
			System.out.print(e + " ");
		}
	}

	private static void mergeSortedArr(int[] a, int[] b) {
		for (int j = b.length - 1; j >= 0; j--) {
			int temp = a[a.length - 1], i;
			boolean isSwapNeeded = false;
			for (i = a.length; i > 0 && b[j] < a[i - 1]; i--) {
				isSwapNeeded = true;
				if(i < a.length)
				a[i] = a [i - 1]; 
			}
			if(isSwapNeeded) {
				a[i] = b[j];
				b[j] = temp;
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
