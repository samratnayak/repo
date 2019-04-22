package com.arr;

public class MergeWithConstantExtraSpace {
	
	static void merge(int ar1[], int ar2[], int m, int n)
	{
	    // Iterate through all elements of ar2[] starting from
	    // the last element
	    for (int i=n-1; i>=0; i--)
	    {
	        /* Find the smallest element greater than ar2[i]. Move all
	           elements one position ahead till the smallest greater
	           element is not found */
	        int j, last = ar1[m-1];
	        for (j=m-1; j >= 0 && ar1[j] > ar2[i]; j--) {
	        	if(j == 0)
	        		continue;
	        	else
	        		ar1[j] = ar1[j-1];
	        }
	 
	        // If there was a greater element
	        if (j != m-1)
	        {
	            ar1[j+1] = ar2[i];
	            ar2[i] = last;
	        }
	    }
	}


	public static void main(String[] args) {
		int[] arr1 = {5, 6, 20};
		int[] arr2 = {1, 2, 4};
		System.out.println("before ..");
		showArr(arr1);
		showArr(arr2);
		merge(arr1, arr2, arr1.length, arr2.length);
		System.out.println("\nafter ..");
		showArr(arr1);
		showArr(arr2);
	}


	private static void showArr(int[] arr1) {
		for(int e : arr1) {
			System.out.print(e+" ");
		}
	}

}
