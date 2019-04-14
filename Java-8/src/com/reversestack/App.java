package com.reversestack;

import java.util.Stack;

public class App {
public static void main(String [] args) {
	Stack<Integer> st = new Stack<>();
	st.push(3);
	st.push(10);
	st.push(20);
	st.push(25);
	System.out.println("Before "+st);
	/*//reverseStack(st);
	int temp = st.pop();
	System.out.println(temp);*/
	reverseStack(st);
	System.out.println("After "+st);
}

private static void reverseStack(Stack<Integer> st) {
	if(st.isEmpty())
		return;
	int temp = st.pop();
	reverseStack(st);
	//System.out.println("Stack before call"+st);
	insertInEndOfStack(temp, st);
	//System.out.println("Stack "+st);
}

private static void insertInEndOfStack(int data, Stack<Integer> st) {
	if(st.isEmpty()) {
		st.push(data);
		return;
	}
	int temp = st.pop(); 
	insertInEndOfStack(data, st);
	st.push(temp);
}
}
