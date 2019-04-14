package com.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfThree {

	private int[] ar;
	public SumOfThree(int size) {
		ar = new int[size];
		for(int i = 0; i < size; i++) {
			if(i %2 == 0)
				ar[i] =  - i + (i/2) - 1;
			else
				ar[i] = i+(i/2) + 2;
		}
		Arrays.sort(ar);
		for(int e : ar) {
			System.out.print(e+" ");
		}
		System.out.println("");
	}
	
	public void findSumOfThree(){
		List<int[]> uniqueIndexedInts = new ArrayList<>();
			getUniqueLists(ar, 0, 0, 2, new int[2], uniqueIndexedInts);
		int thirdIndex = -1;
		for(int[] comb : uniqueIndexedInts) {
			// System.out.print(comb[0] +" "+comb[1]);
			// System.out.println("");
			thirdIndex = binarySearch( -(ar[comb[0]] + ar[comb[1]]), 0, ar.length-1);
			if(thirdIndex != comb[0] && thirdIndex != comb[1] && thirdIndex != -1) {
				comb[2] = thirdIndex;
			// System.out.println("indx "+thirdIndex);
			}
		}
		System.out.println(" ");
		Map<String, Object> map = new HashMap<>();
		for(int[] item : uniqueIndexedInts) {
			Arrays.sort(item);
			if(item[0] != -1  && !map.containsKey((""+item[0])+("-"+item[1])+("-"+item[2]))) {
				map.put((""+item[0])+(""+item[1])+(""+item[2]),"");
			System.out.print(item[0]+" "+item[1]+" "+item[2]);
			System.out.println("");
			}
		}
		}
	
	private int binarySearch(int key, int start, int end) {
		if(start > end) {
			return -1;
		}
		int mid = start + (end-start)/2;
		if(ar[mid] == key) {
			return mid;
		}
		else if (ar[mid] > key) {
			return binarySearch(key, start, mid-1);
		}
		else {
			return binarySearch(key, mid+1,end);
		}
	}

	private void getUniqueLists(int[] ar, int start,  int index, int r, int[] uniqueArr, List<int[]> uniqueIndexedInts) {
		if(index == r ) {
			int[] temp = new int[r+1];
			int k = 0;
			for(int d : uniqueArr) {
				temp[k++] = d;
			}
			temp[k] = -1;
			uniqueIndexedInts.add(temp);
			return;
		}
		for(int j=start; j< ar.length && ar.length -j >= r-index ; j++) {
			uniqueArr[index] = j;
			getUniqueLists(ar, j+1, index+1, r, uniqueArr, uniqueIndexedInts);
		}
	}

	
	public static void main(String[] args) {
		long timeStart = System.currentTimeMillis();
		SumOfThree st = new SumOfThree(4000);
		st.findSumOfThree();
		System.out.println("Time taken "+(System.currentTimeMillis()  - timeStart));
	}
}
