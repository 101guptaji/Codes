package arrays;
import java.util.Scanner;
/*
 * Method-3
 * Using Binet's Formula for the Nth Fibonacci ) 
It involves the usage of our golden section number Phi.
Phi = ( sqrt(5) + 1 ) / 2
Using approximation equation is good enough here, since we know N >= 0 && N <= 30, we can safely use the following rounded function
Fib(N) = round( ( Phi^N ) / sqrt(5) )

Full mathematical explanation of Binet's Formula - https://r-knott.surrey.ac.uk/Fibonacci/fibFormula.html 
 */
public class FibonacciUsingFormula {

	static int fib(int n) {
		if(n <= 1)
			return n;
		double phi = (Math.sqrt(5)+1)/2;
		return (int)Math.round(Math.pow(phi, n)/Math.sqrt(5));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fib(n));
		
	}

}
