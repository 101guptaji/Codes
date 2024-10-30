/* Problem:
 * Given two strings S1 and S2 consisting of only lowercase characters whose anagrams are almost equal. The task is to count the number of characters which needs to be edited(delete) to make S1 equal to S2.

	Example 1:
	
	Input:
	madame
	madam
	
	Output:
	1
	
	Explanation:
	String S1 = madame, string S2 = madam. character 'e' in 
	first string is need to be deleted to make S1 equal to S2
 */
package Strings;

import java.util.*;

class AlmostEquals
{
	/*Function to count number of characters 
	* to make s1 and s2 equal
	* s1 : first string
	* s2 : second string
	*/
	static int coutChars(String s1, String s2)
	  {
			//Your code here
	       int n1 = s1.length();
	       int n2 = s2.length();
	       
	       //frequency array of letters in given strings
	       int[] freq1 = new int[26];
	       int[] freq2 = new int[26];
	       
	       for(int i=0;i<n1;i++){
	           freq1[s1.charAt(i)-'a']++;
	       }
	       
	       for(int i=0;i<n2;i++){
	           freq2[s2.charAt(i)-'a']++;
	       }
	       
	       //counting no of different chars in both strings
	       int diff = 0;
	       for(int i=0;i<26;i++){
	           diff += Math.abs(freq1[i]-freq2[i]);
	       }
	       return diff;
	  }
	
	//driver code
	public static void main (String[] args)
	{
	     //taking input using Scanner class
  	 Scanner sc = new Scanner(System.in);
  	 
  	 //taking total number of testcases
  	 int t = sc.nextInt();
  	 
  	 while(t-- > 0){
  	   
  	   //taking the 2 strings
  	   String s1=sc.next();
  	   String s2=sc.next();
  	   
  	   //calling coutChars method and passing
  	   //both the Strings and printing
  	   //the result
  	   System.out.println(coutChars(s1,s2));
  	   
  	 }
  }
}
