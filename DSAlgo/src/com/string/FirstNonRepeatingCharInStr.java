package com.string;

public class FirstNonRepeatingCharInStr {

	public static void main(String[] args) {
		
		String a = "firstinfirstoutnou";
		
		String res = findFirstNonRepeating(a);
		System.out.println(res);
	}

	static class CountAndIndex implements Comparable<CountAndIndex>{
		int index;
		int count;
		@Override
		public String toString() {
			return "CountAndIndex [index=" + index + ", count=" + count + "]";
		}
		CountAndIndex(int index){
			this.count = 1;
			this.index = index;
		}
		public void incrementCount() {
			count++;
		}
		@Override
		public int compareTo(CountAndIndex o) {
			if(o != null) {
			int countComp = count == o.count ? 0 : count < o.count ? -1 : 1;
			if (countComp == 0) {
				return index < o.index ? -1 : index == o.index ? 0 : 1;
			}
			return countComp;
			}
			return -1;
		}
	} 
	
	private static String findFirstNonRepeating(String a) {
		CountAndIndex[] ref = new CountAndIndex[256]; 
		for(int i = 0; i < a.length() ; i++) {
			CountAndIndex ob = ref[(int)a.charAt(i)];
			if(ob != null) {
				ob.incrementCount();
			} else {
				ref[(int)a.charAt(i)] = new CountAndIndex(i);
			}
		}
		int charVal = Integer.MAX_VALUE;
		for(int i = 0; i< ref.length; i++) {
			if(ref[i] != null && ref[i].count == 1 && i < charVal ) {
				charVal = i;
			}
		}
		return String.valueOf((char)charVal);
	}

}
