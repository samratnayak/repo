package com.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class EaseTheArray {

	public static void main(String[] args) throws IOException {
		//Math.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++){
		    int n = Integer.parseInt(br.readLine());
		    int a[] = new int[n];
		    String[] values = br.readLine().split("\\s");
		    for(int j = 0; j < n; j++){
		        a[j] = Integer.parseInt(values[j]);
		    }
		    easeArray(a, n);
		    for(int e : a)
				sb.append(e+" ");
		    sb.append("\n");
		}
		
		System.out.println(sb.toString());
		// sc.close();
	}

	private static void easeArray(int[] a, int n) {

		int replaceI = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] != 0 && (i +1) < a.length && a[i] == a[i+1]) {
				a[i + 1] = 0;
				a[i] = a[i] * 2;
			}
			int temp  = a[i];
			if(a[i] != 0 && i != replaceI) {
				swap(a, i, replaceI);
			}
			if(temp != 0 ) {
				replaceI ++;
			}
		}
	}

	private static void swap(int[] a, int i, int replaceI) {
		int temp = a[i];
		a[i] = a[replaceI];
		a[replaceI] = temp;
	}

}
