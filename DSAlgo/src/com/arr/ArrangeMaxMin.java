package com.arr;

public class ArrangeMaxMin {

	public static void main(String[] args) {
		// given a sorted arr
		int a[] = { 2, 4, 6, 9, 13, 17, 20, 29, 35, 45 , 80  };
		int x = (int) (a.length - 1) / 2;
		System.out.println("x = " + x);
		System.out.println("before..");
		display(a);
		arrangeInOrder(a);
		System.out.println("after..");
		display(a);
	}

	private static void arrangeInOrder(int[] a) {
		// logic based on the fact that
		// i th element will be j th postion
		// where j = (2 * i) + 1; when i < n/2 else j = 2 * (n-i-1)
		int i = 0, pos = 0;
		int val = a[0];
		while (pos >= 0 && pos < a.length) {
			if (val > 0) {
				int j = i < a.length / 2 ? (2 * i) + 1 : 2 * (a.length - i - 1);
				// System.out.println("i " + i + "j " + j + " val " + val);
				int temp = a[j];
				a[j] = -val;
				i = j;
				val = temp;
			} else {
				pos++;
				if (pos < a.length - 1) {
					i = pos;
					val = a[pos];
				}
			}
		}
	}

	private static void display(int[] a) {
		System.out.println("");
		for (int i : a) {
			System.out.print(-i + " ");
		}
	}

}
