package com.search;

import java.util.Arrays;
import java.util.Optional;

public class MaxDivisibleSum {

	static int maxSum = 0;
	static int[] resArr = new int[0];

	public static void main(String[] args) {
		int[] arr = { 2, 5, 9, 2, 59, 59, 5, 10, 1, 552 };
		// {3, 10, 99, 53, 11, 63, 5, 8};
		int divisor = 111;
		int sum = 0;
		int res[] = null;
		for(int i = 0; i < arr.length; i++) {
			res = new int[arr.length - i ];
			sum = findMaxDivisibleSum(arr, 0, divisor, 0, res, arr.length - i);
		 if( sum > 0)
			 break; 
		}
		
		System.out.println(sum);
		// res = new int[10];
		System.out.println("Elements : ");
		for(int n : resArr) {
			System.out.print(n+" ");
		}
	}

	private static int findMaxDivisibleSum(int[] arr, int st, int div, int curr, int[] res, int maxElmt) {
		if(maxElmt == curr) {
			Optional<Integer> op = Arrays.stream(res)
					.mapToObj(Integer::valueOf)
					.reduce((e, e1) -> e + e1);
			int sum = op.get();
			if (sum > maxSum && sum % div == 0) {
				maxSum = sum;
				additionalStepForElements(res);
			}
			return maxSum;
		} 
		for (int i = st; i < arr.length && (arr.length - i) >= (maxElmt - curr); i++) {
			res[curr] = arr[i];
			findMaxDivisibleSum(arr, i + 1, div, curr + 1, res, maxElmt);
		}
		return maxSum;
	}

	private static void additionalStepForElements(int[] res) {
		resArr = Arrays.copyOf(res, res.length);
	}

	private static int findMaxDivisibleSumWithIndex(int[] arr, int st, int div, int sum, int ansInd[]) {
		if (sum > maxSum && sum % div == 0) {
			maxSum = sum;
		}
		int localSum = 0;
		for (int i = st; i < arr.length; i++) {
			localSum += arr[i];
			//findMaxDivisibleSum(arr, i + 1, div, localSum);
		}
		return maxSum;
	}
}
