package arrays;
import java.util.Scanner;
/*
 * Method-2
 * The Fibonacci numbers are the numbers in the following integer sequence.
	0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ........
	
	In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation 
	
	Fn = Fn-1 + Fn-2
	with seed values 
	
	F0 = 0 and F1 = 1.
 */
public class FibonacciUsingRecursion {
	
	static int fib(int n) {
		if(n <= 1)
			return n;
		return fib(n-1) + fib(n-2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fib(n));
		
	}
}
