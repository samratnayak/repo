package com.geeksforgeeks;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// long start = 0;
		int ans[] = new int[t];
		for(int i = 0; i < t; i++){
		    int n = sc.nextInt();
		    int x = sc.nextInt();
		    int a[] = new int[n];
		    for(int j = 0; j < n; j++){
		        a[j] = sc.nextInt();
		    }
		 // start = System.currentTimeMillis();
		  Arrays.sort(a);  
		  ans[i] = findCountOfTriplets(a, n, x);
		}
		for(int a : ans)
		System.out.println(a);
		sc.close();
		// System.out.println("time = "+ (( System.currentTimeMillis()- start)));
		
	}
	static int findCountOfTriplets(int[] a, int n, int x){
	    int count = 0;
	    for(int i = 0; i < a.length - 2; i++) {
	    	if(a[i + 1] >= x - a[i]) {
	    		break;
	    	}
	        for(int j = i + 1; j < a.length -1; j++){
	        	if(a[j] >= 0 && a[i] + a[j] >= x) {
		    		break;
		    	}
	        	 for(int k = j + 1; k < a.length; k++){
	        		 if(a[k] >= 0 && a[i] + a[j] + a[k] >= x) {
	 		    		break;
	 		    	}
	        		if(a[i] + a[j] + a[k] < x) {
		                    count++;
		             }
	 	        }  
	        }
	    }
		return count;    
	}
	
	static int findCountOfTripletsBinarySearch(int[] a, int n, int x){
	    int count = 0;
	    for(int i = 0; i < a.length - 2; i++) {
	    	int startPos  = findPos(a, x - a[i]);
	    }
		return count;    
	}
	private static int findPos(int[] a, int i) {
		return 0;
	}
}
