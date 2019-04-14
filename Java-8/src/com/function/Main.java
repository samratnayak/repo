package com.function;

import java.util.function.Function; 
  
public class Main { 
    public static void main(String args[]) 
    { 
        // Function which takes in a number and 
        // returns half of it 
        Function<Integer, Double> half = a -> a / 2.0; 
  
        // Now treble the output of half function 
        Function<Integer, Double> finalFuncn = half.andThen(a -> 3 * a); 
  
        // apply the function to get the result 
        System.out.println(finalFuncn.apply(10));
        System.out.println(Function.identity().apply(560));
    } 
} 