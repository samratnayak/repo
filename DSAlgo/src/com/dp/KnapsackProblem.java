package com.dp;

public class KnapsackProblem {
	 
	static int maxGlobalVal = Integer.MIN_VALUE;

	public static void main(String[] args) {
		int val[] = {400, 500, 1000, 300, 240};
		int w[] =   {25, 40, 50, 50, 10};
		int maxWeight = 100;
		int maxVal = Math.max(findMaxValue(0, val, w, maxWeight, w[0], val[0]), findMaxValue(0, val, w, maxWeight, 0, 0));
		System.out.println(maxVal > maxGlobalVal ? maxVal : maxGlobalVal);
	}

	private static int findMaxValue(int start, int[] val, int[] w, int maxWeight, int currW, int currVal) {
		if (currW >= maxWeight || start >= val.length) {
			System.out.println("curr val "+currVal+" curr w"+currW);
			return currVal;
		}
		int maxV1 = Integer.MIN_VALUE, maxV2 = maxV1;
		for (int i = start + 1; i < val.length; i++) {
			// case when item is selected
			maxV1 = currW + w[i] > maxWeight ? currVal
					: findMaxValue(i, val, w, maxWeight, currW + w[i], currVal + val[i]);
			//System.out.println("maxV1 "+maxV1);
			// case when item is not selected
			maxV2 = findMaxValue(i, val, w, maxWeight, currW, currVal);
			int maxLocal =  Math.max(maxV1, maxV2);
			if(maxLocal > maxGlobalVal) {
				maxGlobalVal = maxLocal;
			}
		}
		return maxGlobalVal;
	}

}
