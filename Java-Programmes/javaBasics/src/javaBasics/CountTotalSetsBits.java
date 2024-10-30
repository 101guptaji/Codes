/* Problem:
 * You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).
	Example:
	Input: N = 4
	Output: 5
	Explanation:
	For numbers from 1 to 4.
	For 1: 0 0 1 = 1 set bits
	For 2: 0 1 0 = 1 set bits
	For 3: 0 1 1 = 2 set bits
	For 4: 1 0 0 = 1 set bits
	Therefore, the total set bits is 5.
	
	Expected Time Complexity: O(log N).
	Expected Auxiliary Space: O(1).
	
	Constraints:
	1 ≤ N ≤ 10^8
*/

package javaBasics;

import java.util.*;
import java.io.*;
/*
 * Approach:
 * If we observe bits from rightmost side at distance i than bits get inverted after 2^i position in vertical sequence. 
	for example n = 5; 
	0 = 0000 
	1 = 0001 
	2 = 0010 
	3 = 0011 
	4 = 0100 
	5 = 0101
	Observe the right most bit (i = 0) the bits get flipped after (2^0 = 1) 
	Observe the 3rd rightmost bit (i = 2) the bits get flipped after (2^2 = 4) 
	So, We can count bits in vertical fashion such that at i'th right most position bits will be get flipped after 2^i iteration;
 */
class Solutions{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
    	if(n == 0)
    		return 0;
    	
    	int x = largestPowOf2(n);
    	int y = (int) (x * Math.pow(2, x-1)); // Math.pow(2,x) = 1<<x
    	int z = (int) (n - Math.pow(2, x));

        return y+z+1+countSetBits(z);
    }

	private static int largestPowOf2(int n) {
		int x = 0;
		while(Math.pow(2, x) <= n) {
			x++;
		}
		return x-1;
	}
    
}

//{ Driver Code Starts.

// Driver code
public class CountTotalSetsBits {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();//input n

	    System.out.println(Solutions.countSetBits(n));//calling countSetBits() method
	}
}

// } Driver Code Ends

//Solution: https://www.youtube.com/watch?v=PW2aK1QBBoc