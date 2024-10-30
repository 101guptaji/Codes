/*
 * Problem:
 * Given a number x and two positions (from the right side) in the binary representation of x, write a function that swaps n bits at the given two positions and returns the result. It is also given that the two sets of bits do not overlap.

	Method-1
	Let p1 and p2 be the two given positions.
	
	Example: 
	Input:
	x = 47 (00101111)
	p1 = 1 (Start from the second bit from the right side)
	p2 = 5 (Start from the 6th bit from the right side)
	n = 3 (No of bits to be swapped)
	Output:
	227 (11100011)
	The 3 bits starting from the second bit (from the right side) are 
	swapped with 3 bits starting from 6th position (from the right side)
*
 */
package javaBasics;

/*
 * Approach (Using XOR):
 * 1) Move all bits of the first set to the rightmost side
   	set1 =  (x >> p1) & ((1 << n) - 1)
	Here the expression (1 << n) - 1 gives a number that contains last n bits set and other bits as 0. 
	We do & with this expression so that bits other than the last n bits become 0.
	2) Move all bits of second set to rightmost side
	   set2 =  (x >> p2) & ((1 << n) - 1)
	3) XOR the two sets of bits
	   xor = (set1 ^ set2) 
	4) Put the xor bits back to their original positions. 
	   xor = (xor << p1) | (xor << p2)
	5) Finally, XOR the xor with original number so 
	   that the two sets are swapped.
	   result = x ^ xor
 */
public class SwapBits {
	
	 static int swapBits(int x, int p1, int p2, int n)
	    {
	        // Move all bits of first set
	        // to rightmost side
	        int set1 = (x >> p1) & ((1 << n) - 1);

	        // Move all bits of second set
	        // to rightmost side
	        int set2 = (x >> p2) & ((1 << n) - 1);

	        // XOR the two sets
	        int xor = (set1 ^ set2);

	        // Put the xor bits back to
	        // their original positions
	        xor = (xor << p1) | (xor << p2);

	        // XOR the 'xor' with the original number
	        // so that the  two sets are swapped
	        int result = x ^ xor;

	        return result;
	    }

	    // Driver program
	    public static void main(String[] args)
	    {
	        int res = swapBits(47, 1, 5, 3);
	        System.out.println("Result = " + res);
	    }
}
