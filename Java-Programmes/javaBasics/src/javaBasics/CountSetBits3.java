package javaBasics;

import java.util.Scanner;

/*
 * Write an efficient program to count the number of 1s in the binary representation of an integer.
 * using built-in function
 */
public class CountSetBits3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println("No. of sets bits: "+Integer.bitCount(n));
		//System.out.println("Binary representation of "+n+" is: "+Integer.toString(n, 2));
	}
}
