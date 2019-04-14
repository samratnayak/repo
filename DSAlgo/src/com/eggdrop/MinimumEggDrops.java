package com.eggdrop;

import java.util.HashMap;
import java.util.Map;

public class MinimumEggDrops {

	public static Map<String, Integer> table = new HashMap<String, Integer>();
	public static void main(String[] args) {
		int eggs = 6, floors = 3, curr = 3;
		int minDrops = Integer.MAX_VALUE;
		while(curr > 1 ) {
			int tempDrops = findMinDropsInWorstCase(eggs, floors, curr--);
			minDrops = tempDrops < minDrops ? tempDrops : minDrops;
		}
		System.out.println(minDrops);
	}

	private static int findMinDropsInWorstCase(int eggs, int floors, int curr) {
		if (eggs == 1) {
			return floors;
		}
		if (floors == 1) {
			return 1;
		}

		// Egg  breaks
		int case1Count = curr - 1 == 0 ? 1 : Integer.MAX_VALUE;
		for (int i = curr - 1; i >= 1; i--) {
			if (!presentInTable(eggs -1 , floors)) {
				int temp = findMinDropsInWorstCase(eggs -1, curr - 1, i);
				case1Count = temp < case1Count ? temp : case1Count;
			}
			else {
				//case1Count = map.getVal(floors +"-" +eggs);
			}
		}
		//Egg doesn't break
		int case2Count = curr + 1 > floors ? 1: Integer.MAX_VALUE;
		for (int i = curr + 1; i <= floors; i++) {
			int temp = findMinDropsInWorstCase(eggs, floors - curr, i - curr );
			case2Count = temp < case2Count ? temp : case2Count;
		}
		// table.put(key, value)
		return case1Count > case2Count ? case1Count + 1 : case2Count + 1;
	}

	private static boolean presentInTable(int eggs, int floors) {
		return false;
	}

}
