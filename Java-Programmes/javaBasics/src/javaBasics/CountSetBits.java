package javaBasics;

import java.util.Scanner;

/*
 * Write an efficient program to count the number of 1s in the binary representation of an integer.
 */
public class CountSetBits {

	static int countSetBits(int n) {
		int count = 0;
		while(n>0) {
//			count += n % 2;
//			n = n/2;
			count += n & 1;
            n >>= 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println("No. of sets bits: "+countSetBits(n));
		//System.out.println("Binary representation of "+n+" is: "+Integer.toString(n, 2));
	}

}

//Time Complexity: O(logn) 

//Auxiliary Space: O(1)
