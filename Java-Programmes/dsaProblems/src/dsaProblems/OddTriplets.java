/*
 * Problem:
 * Odd Triplets

	Given an array A[ ] of N integers and an integer X. The task is to count all the triplets (i, j, k) where 1 ≤ i ≤ j ≤ k ≤ N which satisfies the below conditions.
	1. X ≤ j - i and X ≤ k - j.
	2. A[i], A[j] and A[k] are odd.
	
	Example 1:
	Input:
	N = 4
	X = 1
	A[] = {1, 2, 3, 3}
	Output: 1
	Explanation: There is only 1 triplet: (i=1, j=3, k=4) which satisfies all conditions.
	  
	Example 2:
	Input: 
	N = 3
	X = 2
	A[] = {2, 3, 4}
	Output: 0
	Explanation: No such triplet exists.
 */
package dsaProblems;

import java.io.*;

class OddTriplets{
  public static void main(String args[]) throws IOException { 
      BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(read.readLine());
      
      while(t-- > 0){
          
          String input_line[] = read.readLine().trim().split("\\s+");
          int N = Integer.parseInt(input_line[0]);
          int X = Integer.parseInt(input_line[1]);
          
          input_line = read.readLine().trim().split("\\s+");
          int A[]= new int[N];
          for(int i = 0; i < N; i++)
              A[i] = Integer.parseInt(input_line[i]);

          
          long ans = countTriplet(N, A, X); 
          System.out.println(ans);
      }
  } 
  
  static long countTriplet(int n, int a[],int x) 
  { 
      // code here
      long ans=0,p=0,q=0;
      for(int i=x;i<n;i++)
      {
          if(a[i]%2==1)
              q++;
      }

      for(int j=0;j<n;j++)
      {
          if(j-x>=0 && a[j-x]%2==1)
              p++;
          
          if(a[j]%2==1)
          ans+=p*q;

          if(j+x<n && a[j+x]%2==1)
              q--;
      }
      return ans;
  }
  
} 
