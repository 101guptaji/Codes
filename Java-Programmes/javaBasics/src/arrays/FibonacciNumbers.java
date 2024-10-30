package arrays;
import java.util.Scanner;
////Fibonacci Series using Dynamic Programming (Method-1)
/*
 * The Fibonacci numbers are the numbers in the following integer sequence.
	0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ........
	
	In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation 
	
	Fn = Fn-1 + Fn-2
	with seed values 
	
	F0 = 0 and F1 = 1.
 */
public class FibonacciNumbers {

	static int fib(int n) {
		if(n <= 1)
			return n;
		else {
			int arr[] = new int[n+1];
			arr[0] = 0;
			arr[1] = 1;
			for(int i =2;i<=n;i++) {
				arr[i] = arr[i-1]+arr[i-2];
			}
			return arr[n];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fib(n));	
	}
}
