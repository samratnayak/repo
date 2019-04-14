package com.hackerrank;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int toys(int[] w) {
        // Complete this function
    	Arrays.sort(w);
    	int rangeCount = 0;
    	int ub = -1;
    	for(int e : w) {
    		if(ub == -1) {
    			ub = e + 4;
    			rangeCount++;
    		}
    		if(e > ub) {
    			ub = e + 4;
    			rangeCount++;
    		}
    	}
    	return rangeCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] w = new int[n];
        for(int w_i = 0; w_i < n; w_i++){
            w[w_i] = in.nextInt();
        }
        int result = toys(w);
        System.out.println(result);
        in.close();
    }
}