package com.hw;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		//int arr[] = {15, 1, 2, 3, 4, 5, 6, 7,8,9,10, 11, 12, 13}; /*{1, 3, 2, 4, 5, 9000000, 3, 4 , 5, 7, 8, 9 , 10, 11, 12, 13, 14, 17, 18, 19};*/
		int[] newArr = new int[1000];
		/*for(int i = 0; i < 100000; i++) {
			newArr[i] = i < arr.length ? arr[i] : 100 +i;
		}
		arr = newArr;*/
		Scanner sc = new Scanner(System.in);
		int len  = sc.nextInt();
		int arr[] = new int[len];
		for(int i = 0; i < len; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println("arr ..");
		
		//displayArr(arr);
		System.out.println("finsihed arr ..");
		int size = arr.length;
		int prevSize = size;
		int[] temp = new int[2];
		int days = 0;
		while(prevSize > 0) {
			temp = new int[prevSize];
			int index = 0;
			temp[index++] = arr[0];
			for(int  i=0; i< prevSize -1 ; i++) {
				if(arr[i] > arr[i+1]) {
					continue;
				}
				temp[index++] = arr[i+1];
			}
			if(index == prevSize) {
				break;
			}
			days++;
			prevSize = index;
			arr = temp;
			/*System.out.println("display tepm ..");
			displayArr(temp);
			System.out.println("finished temp..");*/
		}
		System.out.println(days);
		displayArr(temp);
		optimizedVersion(arr);
	}

	private static void optimizedVersion(int[] arr) {
		int counter = 0, key = arr[0], prevKey = arr[0];
		for(int i = 1; i < arr.length ; i++) {
			if(i ==1) {
				if(key >  arr[i]) {
					counter++;
					key = arr[i];
				}
				else {
					key = arr[i];
				}
				continue;
			}
			// desc order
			if(prevKey > key && key > arr[i]) {
				prevKey = key;
				key = arr[i];
			} else if(key > prevKey && prevKey > arr[i]) {
				prevKey = key;
				key = arr[i];
				counter++;
				//ascending order
			} else if(arr[i] > prevKey && prevKey > key) {
				prevKey = key;
				key = arr[i];
				continue;
			} else if(prevKey > arr[i] && prevKey > key && key < arr[i]) {
				prevKey = key;
				key = arr[i];
				counter++;
			}
		
		}
	}

	private static void displayArr(int[] temp) {
		for(int a : temp) {
			System.out.print(a+" ");
		}
	}

}
