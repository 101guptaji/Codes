/*
 * Problem:
 * Given an array arr[] denoting heights of N towers and a positive integer K.
	For each tower, you must perform exactly one of the following operations exactly once.
	
	Increase the height of the tower by K
	Decrease the height of the tower by K
	Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.
	
	You can find a slight modification of the problem here.
	Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.
	
	Examples :
	
	Input: k = 2, arr[] = {1, 5, 8, 10}
	Output: 5
	Explanation: The array can be modified as {1+k, 5-k, 8-k, 10-k} = {3, 3, 6, 8}.The difference between the largest and the smallest is 8-3 = 5.
	Input: k = 3, arr[] = {3, 9, 12, 16, 20}
	Output: 11
	Explanation: The array can be modified as {3+k, 9+k, 12-k, 16-k, 20-k} -> {6, 12, 9, 13, 17}.The difference between the largest and the smallest is 17-6 = 11. 
	Expected Time Complexity: O(n*logn)
	Expected Auxiliary Space: O(n)
 */
package dsaProblems;

import java.io.*;
import java.util.*;

public class MinimizeTheHeight {

  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int tc = Integer.parseInt(br.readLine().trim());
      while (tc-- > 0) {
          String[] inputLine;
          inputLine = br.readLine().trim().split(" ");
          int k = Integer.parseInt(inputLine[0]);

          // Ensure input is read correctly
          inputLine = br.readLine().trim().split(" ");
          if (inputLine == null || inputLine.length == 0) {
              System.out.println("Invalid input");
              continue;
          }

          int[] arr = new int[inputLine.length];
          for (int i = 0; i < inputLine.length; i++) {
              arr[i] = Integer.parseInt(inputLine[i]);
          }

          int ans = getMinDiff(arr, k);
          System.out.println(ans);
      }
  }
  
  static int getMinDiff(int[] arr, int k) {

      // Sort the array to handle elements in order.
      Arrays.sort(arr);
      int n = arr.length;
      
      // Initialize the result as the difference between the max and min height in the sorted array.
      int result = arr[n-1]-arr[0];
      
      int minHite = 0;
      int maxHite = 0;
      
      // Traverse through the array to explore the different possibilities
      for(int i=0;i<n-1;i++){
          minHite = Math.min(arr[0]+k, arr[i+1]-k);
          maxHite = Math.max(arr[n-1]-k, arr[i]+k);
          
          // If the new height is negative, skip to avoid invalid cases    
          if(minHite<0)
              continue;
              
          // Update the result with the minimum possible difference
          result = Math.min(result, maxHite-minHite);
      }
      
      return result;
  }
}

/*
 * Explanation:
	Initial Difference: The difference between the tallest (arr[n-1]) and the shortest (arr[0]) is calculated initially.
	Adjustments:
		The smallest possible height can be obtained by either increasing the smallest element by k or 
		decreasing a larger element by k (ensuring no negative values).
		Similarly, the largest possible height can be obtained by either decreasing the maximum tower by k or increasing the smallest element by k.
	Skip Negative Heights: If decreasing by k results in a negative height, we skip that iteration.
	Iterating and Minimizing: As we iterate, we compute the minimum difference between the maximum and minimum heights that can be achieved after adjusting each tower.
 */