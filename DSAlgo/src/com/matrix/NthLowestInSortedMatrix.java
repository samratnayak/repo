package com.matrix;

import java.util.PriorityQueue;
import java.util.Queue;

public class NthLowestInSortedMatrix {

	public static void main(String[] args) {
		int m[][] = {
		{3, 9, 14, 20},
		{5, 10, 18, 24},
		{8, 17, 20, 28},
		{15, 21, 32, 35}};
		int a = findNthLowest(m, 5);
		System.out.println(a);
	}

	private static int findNthLowest(int[][] m, int n) {
		Queue<Integer> minHeap = new PriorityQueue<>();
		for(int i = 0; i < m[0].length; i++) {
			minHeap.add(m[0][i]);
		}
		int i = 0, j = 0, min = -1; 
		while(n > 0) {
			min = minHeap.poll();
			minHeap.add(m[i+1][j]);
			minHeap.add(m[i][++j]);
			if(m[i+1][j] < m[i][j+1]) {
				i++;
			} else 
				j++;
		}
		return 0;
	}

}
