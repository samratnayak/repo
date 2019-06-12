package com.matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class NthLowestInSortedMatrix {

	public static void main(String[] args) {
		int m[][] = { { 3, 9, 14, 20 }, { 5, 10, 18, 24 }, { 8, 17, 20, 28 }, { 15, 21, 32, 35 } };
		int a = findNthLowest(m, 8);
		System.out.println(a);
	}

	private static int findNthLowest(int[][] m, int n) {
		Queue<Integer> minHeap = new PriorityQueue<>();
		Map<Integer, String> indexMap = new HashMap<>();
		for (int i = 0; i < m[0].length; i++) {
			indexMap.put(m[0][i], "0-" + i);
			minHeap.add(m[0][i]);
		}
		int i = 0, j = 0, min = -1;
		while (n > 0) {
			min = minHeap.poll();
			String[] indexArr = indexMap.get(min).split("-");
			i = Integer.parseInt(indexArr[0]) + 1;
			j = Integer.parseInt(indexArr[1]);
			if (i < m.length) {
				minHeap.add(m[i][j]);
				indexMap.put(m[i][j], i + "-" + j);
			}
			n--;
		}
		return min;
	}
}
