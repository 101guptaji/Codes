package javaBasics;

import java.util.Scanner;

/*
 * Write an efficient program to count the number of 1s in the binary representation of an integer.
 * 
 * Brian Kernighan's Algorithm: 
	Subtracting 1 from a decimal number flips all the bits after the rightmost set bit(which is 1) including the rightmost set bit. 
	for example : 
	10 in binary is 00001010 
	9 in binary is 00001001 
	8 in binary is 00001000 
	7 in binary is 00000111 
	So if we subtract a number by 1 and do it bitwise & with itself (n & (n-1)), we unset the rightmost set bit. 
	If we do n & (n-1) in a loop and count the number of times the loop executes, we get the set bit count. 
	The beauty of this solution is the number of times it loops is equal to the number of set bits in a given integer. 
 */

public class CountSetBits2 {

	/*static int countSetBits(int n) {
		int count = 0;
		while(n>0) {
			n &= (n-1);
			count++;
		}
		return count;
	}*/
	
	 // recursive function to count set bits
    static int countSetBits(int n)
    {
        // base case
        if (n == 0)
            return 0;
        else
            return 1 + countSetBits(n & (n - 1));
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println("No. of sets bits: "+countSetBits(n));
		//System.out.println("Binary representation of "+n+" is: "+Integer.toString(n, 2));
	}

}

/*
 * Time Complexity: O(logn)

	Auxiliary Space: O(1)
*/
