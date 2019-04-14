package com.arr;

public class RemoveDuplicates {

	public static void main(String[] args) {
		//sorted array
		int ar[] = {3,5,10, 30, 30, 30, 98, 102, 201, 201, 202};
		int newSize = removeDupes(ar);
		printArr(ar, newSize);
		
	}

	private static void printArr(int[] ar, int newSize) {
		for(int i = 0; i< newSize; i++) {
			System.out.print(ar[i]+" ");
		}
	}

	private static int removeDupes(int[] ar) {
		int j = 0;
		for(int i = 1; i< ar.length; i++) {
			if(ar[i] != ar[j] ) {
				ar[++j] = ar[i];
			}
		}
		return j;
	}
}
