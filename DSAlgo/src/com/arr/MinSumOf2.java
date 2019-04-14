package com.arr;

public class MinSumOf2 {
	static int min;
public static void main(String[] args) {
	int[] arr = {
			-7, 65, 50, -30, 60, 17, -30};
	min = Integer.MAX_VALUE;
	int r = 3;
	min = calcMinSumOfTwoElements(arr, 0, 
			new int[r], 0, r);
	System.out.println(min);
}

private static int calcMinSumOfTwoElements(int[] arr, int curr , int[] indexArr, 
		int index, int r) {
	if(index == r) {
		int sum = 0;
		for(int el : indexArr) {
			sum += el;
		}
		if(sum < min) {
		 min = sum; 
		}
		return min;
	}
	int temp  = Integer.MAX_VALUE;
	for(int i= curr; i < arr.length && (arr.length -i) >= (r-index); i++ ) {
		indexArr[index] = arr[i];
		temp = calcMinSumOfTwoElements(arr, i+1, indexArr , index+1, r );
		if(temp < min) {
			min = temp;
		}
		
	}
return min;
}
}
