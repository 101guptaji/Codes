/*
 * given a number on keypad, you have to print all possible names.
 * TC: O(3^n) as one key can contain max 3 char
 */
package Strings;

public class KeypadPhoneCombination {
	public static String[] keypad = {".", "abc", "def", "ghi","jkl", "mno", "pqr", "stu", "vwx","yz"};
	public static void printCombination(String str, int idx, String combination) {
		if(idx == str.length()) {
			System.out.println(combination);
			return;
		}
		
		char num = str.charAt(idx);
		String mapping = keypad[num-'0'];
		
		 for (int i = 0; i < mapping.length(); i++) {
			 printCombination(str, idx+1, combination+mapping.charAt(i));
		}
	}

	public static void main(String[] args) {
		String str = "23";
		printCombination(str, 0, "");

	}

}
