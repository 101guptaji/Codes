/*
 * print all possible substring of same size as of given string
 * TC: O(n!) where n = length of string
 */
package Strings;

public class SubstringsPermutation {
	public static void printPermutation(String str, String perm) {
		if(str.length() == 0) {
			System.out.println(perm);
			return;
		}
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			//"abc" -> "bc"
			String newStr = str.substring(0,i)+str.substring(i+1);
			printPermutation(newStr, perm+c);
		}
	}

	public static void main(String[] args) {
		String str = "abc";
		printPermutation(str, "");
	}

}
