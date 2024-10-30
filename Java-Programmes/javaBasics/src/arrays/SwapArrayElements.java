package arrays;
/*
 * Problem:
 * Given an array arr of n positive integers. The task is to swap every ith element of the array with (i+2)th element.

	Example 1:
	
	Input:
	n = 3
	arr[] = 1 2 3
	Output:
	3 2 1
 */

import java.util.*;
import java.lang.*;
import java.io.*;
public class SwapArrayElements
{
	public static void swapElements(int[] arr, int n)
	  {
	      // Code here
	      for(int i=0;i<n-2;i++){
	          arr[i] = arr[i] ^ arr[i+2];
	          arr[i+2] = arr[i] ^ arr[i+2];
	          arr[i] = arr[i] ^ arr[i+2];
	      }
	  }
	
	  public static void main(String[] args) throws IOException
	  {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int T = Integer.parseInt(br.readLine().trim());
	      while(T-->0)
	      {
	          int n = Integer.parseInt(br.readLine().trim());
	          String[] S = br.readLine().trim().split(" ");
	          int[] arr = new int[n];
	          for(int i = 0; i < n; i++){
	              arr[i] = Integer.parseInt(S[i]);
	          }
	          swapElements(arr, n);
	          for(int i = 0; i < n; i++){
	              System.out.print(arr[i] + " ");
	          }
	          System.out.println();
	      }
	  }
}

//} Driver Code Ends


//User function Template for Java

class Solution
{
  
}