/*
 * There is an array arr of heights of stone and Geek is standing at the first stone and can jump to one of the following: Stone i+1, i+2, ... i+k stone, where k is the maximum number of steps that can be jumped and cost will be |hi-hj| is incurred, where j is the stone to land on. Find the minimum possible total cost incurred before the Geek reaches the last stone.

	Example:
	Input: k = 3, arr[]= [10, 30, 40, 50, 20]
	Output: 30
	Explanation: Geek will follow the path 1->2->5, the total cost would be | 10-30| + |30-20| = 30, which is minimum
	
	Input: k = 1, arr[]= [10, 20, 10]
	Output: 20
	Explanation: Geek will follow the path 1->2->3, the total cost would be |10 - 20| + |20 - 10| = 20.
	
	Expected Time Complexity: O(n*k)
	Expected Auxilary Space: O(n)
	
	Constraint:
	1<= arr.size() <=10^4
	1 <= k <= 100
	1 <= arr[i] <= 10^4
 */
package dsaProblems;

import java.io.*;
import java.util.*;

class MinimumCostProblem {
	
	public static int minimizeCost(int k, int arr[]) {
	     // code here
	     int n = arr.length;
	     //array to store minimum cost from first stone to ith stone.
	     int[] dp = new int[n];
	     Arrays.fill(dp,Integer.MAX_VALUE);
	     
	     //no cost from first stone to first stone 
	     dp[0] = 0;
	     
	     for(int i=0;i<n;i++){
	    	 for(int j=i+1;j<=k+i;j++){
                if(j < n){
                    int cost = Math.abs(arr[i]-arr[j]);
                    dp[j] = Math.min(dp[j], dp[i]+cost);
                }
            }
	     }
	     return dp[n-1];
	 }
	
	//Driver code
	 public static void main(String[] args) throws IOException {
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     int t = Integer.parseInt(br.readLine());
	     while (t-- > 0) {
	         int k = Integer.parseInt(br.readLine());
	         String line = br.readLine();
	         String[] tokens = line.split(" ");
	
	         // Create an ArrayList to store the integers
	         ArrayList<Integer> array = new ArrayList<>();
	
	         // Parse the tokens into integers and add to the array
	         for (String token : tokens) {
	             array.add(Integer.parseInt(token));
	         }
	
	         int[] arr = new int[array.size()];
	         int idx = 0;
	         for (int i : array) arr[idx++] = i;

	         int res = minimizeCost(k, arr);
	
	         System.out.println(res);
	     }
	 }
}