package com.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestLoop {
	static int counter = 0;
	static List<int[]> distinctPerm = new ArrayList<>();
	public static void main(String [] args) {
		int arr[] = {2,4,5,10,9,20,6,11};
		int j = 1;
	while(j < arr.length)
		sortArr(arr, 0, j++);
		printArr(arr, 0);
		int index = 0;
		int r = 2;
		int data[] =  new int[r];
		Map<String, Integer> map = new HashMap<>();
		distinctPerm(arr, 0, data, 0, 2);
	System.out.println("Distinct Index Arr size "+distinctPerm.size());
	System.out.println("\n"+counter);
	for(int [] d: distinctPerm) {
		System.out.println(d[0]+" "+d[1]);
	}
	}

	private static void distinctPerm(int[] arr, int start, int[] data, int index,  int r) {
		counter++;
		if(r == index) {
			int[] temp = new int[r];
			int  i=0;
			for(int d : data) {
				temp[i++] = d;
			}
			distinctPerm.add(temp);
			return;
		}
		
		for(int j = start ; j < arr.length && arr.length - j >= r - index ; j++) {
			data[index] = j;
			distinctPerm(arr, j+1, data, index+1, r);
		}
	}

	private static void printArr(int[] arr, int i) {
		if(i >= arr.length)
			return;
		else 
			System.out.print(arr[i]+" ");
		printArr(arr, i+1);
		
	}

	private static void sortArr(int[] arr, int i, int j) {
		if(i >= arr.length || j >= arr.length) {
			return;
		}
		else if(arr[i] > arr[j] && (i != j)){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		sortArr(arr, i+1, j);
		//sortArr(arr, i, j+1);
	}
}
