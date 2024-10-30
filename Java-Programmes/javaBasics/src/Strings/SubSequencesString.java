/*
 * https://www.youtube.com/watch?v=u-HgzgYe8KA&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=18
 * Time Complexity: O(2^n) where n = length of given string
 * Also, total no. of subsequences = 2^n
 */
package Strings;

import java.util.*;

public class SubSequencesString {
	public static ArrayList<String> list;
	public static HashSet<String> set;
	
	public static void findSubSequence(String str, int idx, String newStr) {
		if(idx == str.length()) {
			list.add(newStr);
			return;
		}
		char c = str.charAt(idx);
		
		//to be
		findSubSequence(str, idx+1, newStr+c);
		
		//not to be
		findSubSequence(str, idx+1,newStr);
	}
	
	public static void findUniqueSubSequence(String str, int idx, String newStr) {
		if(idx == str.length()) {
			set.add(newStr);
			return;
		}
		char c = str.charAt(idx);
		
		//to be
		findUniqueSubSequence(str, idx+1, newStr+c);
		
		//not to be
		findUniqueSubSequence(str, idx+1,newStr);
	}
	
	public static void main(String[] args) {
		list = new ArrayList<>();
		set = new HashSet<>();
		String str = "abc";
		findSubSequence(str, 0, "");
		System.out.println(list.toString());
		findUniqueSubSequence(str, 0, "");
		System.out.println(set.toString());
	}

}
