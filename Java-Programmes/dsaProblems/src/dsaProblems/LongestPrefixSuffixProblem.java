/*
 * Problem:
 * Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.

	NOTE: Prefix and suffix can be overlapping but they should not be equal to the entire string.
	
	Examples :	
	Input: str = "abab"
	Output: 2
	Explanation: "ab" is the longest proper prefix and suffix. 
	
	Input: str = "aaaa"
	Output: 3
	Explanation: "aaa" is the longest proper prefix and suffix. 
	Expected Time Complexity: O(|str|)
	Expected Auxiliary Space: O(|str|)
	
	Constraints:
	1 ≤ |str| ≤ 106
	str contains lower case English alphabets

 */
package dsaProblems;


import java.io.*;

class LongestPrefixSuffixProblem {
 public static void main(String args[]) throws IOException {
     BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
     int t = Integer.parseInt(read.readLine());
     while (t-- > 0) {
         String s = read.readLine();

         System.out.println(lps(s));
     }
 }
 
 static int lps(String str) {
     // code here
     int n = str.length();
     //count of longest prefix
     int count=0;
     //i=prefix starting index, j=suffix starting index
     int i=0, j=1;
     //index of last match suffix start
     int pos=0;
     
     while(i<n && j<n){
         if(str.charAt(i) == str.charAt(j)){
             i++;
             j++;
             count++;
         }
         else{
             i=0;
             count=0;
             pos++;
             j=pos;
         }
     }
     return count;
 }
}
