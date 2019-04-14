package com.arr;

public class SortOnlyWith3Elements {

	public static void main(String[] args) {
		int a[] = { 2, 0, 0, 1, 1, 1, 2, 0, 1, 0, 1, 0, 0 , 2, 1, 2 };

		int start = 0, curr = 0, end = a.length - 1;
		while(curr <= end) {
			switch(a[curr]) {
				case 0:
					swap(a, start, curr);
					start++;
					curr++;
					break;
					
				case 1:
					curr++;
					break;
				case 2:
					swap(a, end, curr);
					end--;
					break;
			}
		}
//		System.out.println(count);
		display(a);
		//sortArr(a);
	}

	private static void sortArr(int[] a) {
		int start = 0, end = a.length - 1, curr = 0;
		while(start <= end) {
			if(a[curr] == 0) {
				curr++;
			}
		}
	}

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void display(int[] a) {
		for (int e : a) {
			System.out.println(e);
		}
	}
}
