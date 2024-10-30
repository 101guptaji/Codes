/*
 * WAP to calculate x^n.
 * TC: O(log n)
 */
package javaBasics;

public class CalculatePower {
	static int getPower(int x, int n) {
		//base cases
		if(n==0)
			return 1;
		if(x==0)
			return 1;
		//if n is even
		if(n%2 == 0) {
			return getPower(x,n/2)*getPower(x,n/2);
		}
		//if n is odd
		else{
			return getPower(x,n/2)*getPower(x,n/2)*x;
 		}
	}
	
	public static void main(String[] args) {
		int x=2, n =5;
		int pow = getPower(x,n);
		System.out.println(pow);
	}
}
/*
 * Approach:
 * since x^n = x^(n/2) * x^(n/2);
 * but in java, n/2 gives integer value i.e 3/2 = 1 not 1.5
 * so, for n = odd,x^n = x^(n/2) * x^(n/2) * x 
 * E.g.: x^5 = x^2 * x^2 * x^1 and x^2 = x^1 * x^1;
 */

