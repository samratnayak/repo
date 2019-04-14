package com.sort;

public class SelSort {

	public int selSort(int[] arr) {
		int count = 0;
		for(int i=0; i < arr.length; i++) {
			int min = arr[i];
			int index = -1;
			for(int j = i+1; j < arr.length; j++) {
				count++;
				if(min >= arr[j]) {
					min = arr[j];
					index = j;
				}
			}
			if(index > 0) {
				swap(i, index, arr);
			}
			/*System.out.println("\n");
			Arrays.stream(arr)
			  .forEach(e -> System.out.print(e + " "));*/
		}
		return count;
	}

	private void swap(int i, int index, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}
}
