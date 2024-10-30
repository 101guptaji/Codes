package arrays;
import java.util.*;

/*
 * Method - 4
 * DP using memoization(Top down approach)

	We can avoid the repeated work done in method 1 by storing the Fibonacci numbers calculated so far. We just need to store all the values in an array.
 */

public class FibonacciUsingDP_Memorisation {

	// Initialize array of dp
	static int[] dp;// = new int[10];

	static int fib(int n)
	{
	    if (n <= 1)
	        return n;
	        
	    // Temporary variables to store
	    // values of fib(n-1) & fib(n-2)
	    int first, second;
	    
	    if (dp[n - 1] != -1)
	        first = dp[n - 1];
	    else
	        first = fib(n - 1);

	    if (dp[n - 2] != -1)
	        second = dp[n - 2];
	    else
	        second = fib(n - 2);

	    // Memoization
	    return dp[n] = first + second;
	}

	// Driver Code
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n+1];

	    Arrays.fill(dp, -1);
		//System.out.println(dp[8]);
	    System.out.print(fib(n));
	}

}
