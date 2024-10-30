/*
 * Problem: 
 * Given a 2D matrix M of dimensions RxC. Find the maximum sum submatrix in it.

	Example 1:	
	Input:
	R=4
	C=5
	M=[[1,2,-1,-4,-20],
	   [-8,-3,4,2,1],
	   [3,8,10,1,3],
	   [-4,-1,1,7,-6]]
	Output:
	29
	Explanation: cell(1,1) to cell(3,3)
	
	Example 2:
	Input:
	R=2
	C=2
	M=[[-1,-2],[-3,-4]]
	Output:
	-1
	Explanation: Taking only the first cell is the optimal choice.
 */
package dsaProblems;

import java.io.*;

class MaximumSumRectangle {
	 public static void main(String args[]) throws IOException {
	     BufferedReader read =
	         new BufferedReader(new InputStreamReader(System.in));
	     int t = Integer.parseInt(read.readLine());
	     while (t-- > 0) {
	         int N, M;
	         String S[] = read.readLine().split(" ");
	         N = Integer.parseInt(S[0]);
	         M = Integer.parseInt(S[1]);
	         int a[][] = new int[N][M];
	         for (int i = 0; i < N; i++) {
	             String s[] = read.readLine().split(" ");
	             for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
	         }
	         
	         System.out.println(maximumSumRectangle(N, M, a));
	     }
	 }
	 
	 public static int maximumSumRectangle(int R, int C, int M[][]) {
		 int maxSum = Integer.MIN_VALUE;
	     for(int i=0;i<R;i++){
	         int[] row = new int[C];
	         for(int j=i;j<R;j++){
	             for(int k=0;k<C;k++){
	                 row[k] += M[j][k]; 
	             }
	             maxSum = Math.max(maxSum, rowMax(row, C));
	         }
	     }
	     return maxSum;
	 }
	 
	 public static int rowMax(int arr[], int n) {
		 int sum = 0;
	     int maxS = Integer.MIN_VALUE;
	     for(int i=0;i<n;i++){
	         sum += arr[i];
	         maxS = Math.max(maxS, sum);
	         sum = Math.max(sum,0);
	     }
	     return maxS;
	 }
}

