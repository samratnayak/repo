package com.palindrome;

public class CheckPalindrome {
public static void main(String[] args) {
	System.out.println("checking no of chars that will make palindrome");
	String st = "rmdr";//"bdbde";
	int chars = checkCharsForPalindrome(st, 0, st.length()-1);
	System.out.println("chars required : "+chars);
}

private static int checkCharsForPalindrome(String s, int start, int end) {
	if(start > end )
		return Integer.MAX_VALUE;
	if(start == end)
		return 0;
	if(start +1 == end)
		return s.charAt(start) == s.charAt(end) ? 0: 1;
	if(s.charAt(start) == s.charAt(end)) 
		return checkCharsForPalindrome(s, start+1, end-1);

	return //checkCharsForPalindrome(s, start, end-1) + 1;
	Math.min(checkCharsForPalindrome(s, start+1, end),	
			checkCharsForPalindrome(s, start, end-1)) +1;
    
}
}
