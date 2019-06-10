package com.allsubset;

public class Subset {

	public static void main(String[] args) {
		int arr[] = {3,5, 8, 7};
		int i = 0;
	 while(++i  < arr.length)
			printAllSubsets(arr, 0, new int[i], 0, i);
	}

	private static void printAllSubsets(int[] arr, int start, int[] ans, int index, int r) {
		if(r == index) {
			for(int a : ans) {
				System.out.print(a+" ");
			}
			System.out.println("");
			return;
		}
		for(int i = start; i < arr.length && arr.length - i >= r-index ; i++) {
			ans[index] = arr[i];
			printAllSubsets(arr, i+ 1, ans, index+ 1, r);
		}
	}
}
