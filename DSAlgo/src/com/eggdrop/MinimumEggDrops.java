package com.eggdrop;

import java.util.HashMap;
import java.util.Map;

public class MinimumEggDrops {

	public static Map<String, Integer> table = new HashMap<String, Integer>();
	public static void main(String[] args) {
		int floors = 7, eggs = 3;
		int minDrops = findMinDropsInWorstCase(eggs, floors);
		System.out.println("final ans "+minDrops);
	}

	private static int findMinDropsInWorstCase(int eggs, int floors) {
		if (eggs == 1) {
			return floors;
		}
		if (floors <= 1) {
			return 1;
		}
		if(table.containsKey(eggs+"-"+floors)) {
			int tries = table.get(eggs+"-"+floors);
			System.out.println("found floors "+floors+" eggs "+eggs+" ans "+tries);
			return tries;
		}
		int minTries = Integer.MAX_VALUE;
		for (int curr = 1; curr <= floors; curr++) {
			// Egg breaks
			int tries1 = findMinDropsInWorstCase(eggs - 1, floors - curr);
			// Egg doesn't break
			int tries2 = findMinDropsInWorstCase(eggs , curr - 1);
			int worstCaseTries = Math.max(tries1, tries2);
			if(worstCaseTries < minTries)
				minTries = worstCaseTries;
		}
		table.put(eggs+"-"+floors, minTries + 1);
		return minTries + 1;
	}
}
