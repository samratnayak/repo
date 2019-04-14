package com.hackerrank.digitsum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
	
	static int superDigit(String no, int k) {
		long sum = sumOfDigits(no);
		sum = sum * k;
		return (int)superDigitFind(String.valueOf(sum));
		
    }

    // Complete the superDigit function below.
    static long superDigitFind(String no) {
        long sum = sumOfDigits(no);
        if(sum / 10 == 0){
            return sum;
        }
       return superDigitFind(String.valueOf(sum)); 
    }

	private static long sumOfDigits(String no) {
		long sum = 0;
		for(int i = 0; i < no.length(); i++) {
        	sum = sum + Integer.valueOf(String.valueOf(no.charAt(i))) ;
        }
		return sum;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        System.out.println("k = "+k);
        int result = superDigit(n, k);

        System.out.println(String.valueOf(result));
        
       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
