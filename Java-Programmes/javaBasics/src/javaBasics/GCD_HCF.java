/*
 * Write a function that calculates the Greatest Common Divisor or Highest Common Factor of 2 numbers.
 */
package javaBasics;

import java.util.Scanner;

public class GCD_HCF {
	static int findGCD(int n1, int n2) {
		while(n1 != n2) {
			if(n1>n2)
				n1 -= n2;
			else
				n2 -= n1;
		}
		
		return n1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println("GCD of"+a+" and "+b+" is "+findGCD(a,b));
		}
		finally {
			sc.close();
		}

	}

}
