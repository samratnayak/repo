package com.dp;

public class LargestCS {

	public static void main(String[] args) {
		String s = "abaacd", s2 = "bacbcd";
		int l = findLCSlength(s, s2);
		System.out.println("max subsequence len "+ l);
	}

	private static int findLCSlength(String s, String s2) {
		int a[][] = new int[s.length()][s2.length()];
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < s2.length(); j++) {
				if(s.charAt(i) == s2.charAt(j)) {
					a[i][j] = i == 0 || j == 0 ? 1 : a[i-1][j-1] + 1;
				} else {
					a[i][j] = i == 0 || j == 0 ? 0 : Math.max(a[i-1][j], a[i][j-1]);
				}
			}
		}
		System.out.println("final table");
		displayArr(a);
		return a[s.length()-1][s2.length()-1];
	}

	private static void displayArr(int[][] a) {
		int b[][][] = new int[3][10][2];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

}
