/*
 * Problem:
 * Given two strings s and p. Find the smallest window in the string s consisting of all the characters(including duplicates) of the string p.  Return "-1" in case there is no such window present. In case there are multiple such windows of same length, return the one with the least starting index.
	Note : All characters are in Lowercase alphabets. 
	
	Examples:
	
	Input: s = "timetopractice", p = "toc"
	Output: toprac
	Explanation: "toprac" is the smallest
	substring in which "toc" can be found.
	Input: s = "zoomlazapzo", p = "oza"
	Output: apzo
	Explanation: "apzo" is the smallest 
	substring in which "oza" can be found.
	Expected Time Complexity: O(|s|)
	Expected Auxiliary Space: O(n), n = len(p)
	
	Constraints: 
	1 ≤ |s|, |p| ≤ 105
 */

package dsaProblems;

import java.util.*;

class SmallestWindowInSstring {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(smallestWindow(s, t));
		    test--;
		}
		scan.close();
	}
	
	//Function to find the smallest window in the string s consisting
	  //of all the characters of string p.
	  public static String smallestWindow(String s, String p)
	  {
	      //Using sliding window algorithm
	      int n=s.length();
	      //int m=p.length();
	      
	      //pFreq is an array of size 26 to store the frequency of each character in the string p.
	      int[] pFreq = new int[26];
	      for(char c : p.toCharArray()){
	          pFreq[c-'a']++;
	      }

	      //l and r are the left and right pointers of the sliding window, respectively.
	      int l=0, r=0;
	      String res=null; //resultant string
	      int resLen = Integer.MAX_VALUE;
	      
	      //winFreq is an array of size 26 to store the frequency of each character in the current window.
	      int[] winFreq = new int[26];
	      
	      while(r<n){
	          winFreq[s.charAt(r)-'a']++;
	          
	          while(l<=r && isSubString(pFreq, winFreq)){
	              if(r-l+1 < resLen){
	                  resLen = r-l+1;
	                  res = s.substring(l, r+1);
	              }
	              winFreq[s.charAt(l)-'a']--;
	              l++;
	          }
	          r++;
	      }
	      
	      return (res == null)? "-1" : res;
	  }
	  
	  //checks if the current window contains all characters of p by comparing the frequencies
	  private static boolean isSubString(int[] pat, int[] window){
	      for(int i=0;i<26;i++){
	          if(pat[i]>0 && pat[i]>window[i]){
	              return false;
	          }
	      }
	      return true;
	  }
}

/*
 * Sliding Window:
	The sliding window is moved to the right by incrementing r.
	For each character in the window, its frequency is incremented in winFreq.
	When the window contains all characters of p (checked using the isSubString function), the window is shrunk from the left by incrementing l.
	During the shrinking process, the minimum window length is updated if a smaller window is found.
 */