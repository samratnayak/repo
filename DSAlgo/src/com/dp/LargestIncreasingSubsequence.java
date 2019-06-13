package com.dp;

public class LargestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = {3, 22, 5, 27, 30, 6};
		int maxL = findLIS(arr, arr.length);
		System.out.println(maxL);
	}

	private static int findLIS(int[] arr, int n) {
		// max sub sequence len is 1 incase curr limit is arr of size 1
		if(n <= 1)
			return 1;
		int maxLen = Integer.MIN_VALUE;
		for(int i = 1; i < n; i++) {
			int lenLocal = 1;
			if(arr[i-1] > arr[n-1]) {
				lenLocal = 1 + findLIS(arr, i-1);
			} else {
				
			}
		}
		return 0;
	}

}
