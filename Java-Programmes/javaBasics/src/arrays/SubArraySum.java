/*
 * Given an unsorted array of integers arr[], and a target tar, determine the number of subarrays whose elements sum up to the target value.

	Examples:
	Input: arr[] = [10, 2, -2, -20, 10] , tar = -10
	Output: 3
	Explanation: Subarrays with sum -10 are: [10, 2, -2, -20], [2, -2, -20, 10] and [-20, 10].
	Input: arr[] = [1, 4, 20, 3, 10, 5] , tar = 33
	Output: 1
	Explanation: Subarray with sum 33 is: [20,3,10].
	Expected Time Complexity: O(n)
	Expected Auxilary Space: O(n)
	 */
package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class SubArraySum {
	// Function to count the number of subarrays which adds to the given sum.
	static int subArray(int[] arr, int tar) {
		// Variable to store the number of subarrays that sum to the target.
		int count = 0;
		
		// Hash map to store cumulative sums and their frequencies.
		HashMap<Integer, Integer> map = new HashMap<>();
		
		// Variable to keep track of the cumulative sum of the array.
		int sum = 0;
		
		// Traverse through the array
		for(int x : arr) {
			sum += x;  // Update the cumulative sum with the current element.
			
			// If the cumulative sum itself equals the target, we found a valid subarray.
			if(sum == tar) {
				count++;
			}
			
			// Check if there's a previous cumulative sum that makes (sum - tar).
			if(map.containsKey(sum-tar)) {
				count += map.get(sum-tar); // Add the frequency of (sum - tar) to the result.
			}
			// Store/update the current cumulative sum's frequency in the map.
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		
		return count; // Return the total count of subarrays that sum to the target.
	}
	
	public static void main(String[] args) throws IOException {
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
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

         int tar = Integer.parseInt(br.readLine());
         
         int res = subArray(arr, tar);

         System.out.println(res);
	     
	}
}

/*
 * Approach:
 * Cumulative Sum:
	As we traverse the array, maintain a running sum (sum) of all elements encountered so far. For each new element arr[i], the sum is updated as sum += arr[i].
   
   Key Observation:
	Let's say sum is the cumulative sum up to index i. If there exists an earlier subarray (ending at index j) whose cumulative sum is sum - tar, then the subarray from j + 1 to i will have a sum equal to tar.
	Why? Because the sum of elements from index j+1 to i is simply the difference between the cumulative sum at i and the cumulative sum at j.
   
   Use of Hash Map:
	We use a hash map (mp) where the key is the cumulative sum and the value is the number of times this sum has been encountered.
	For each new sum, we check if sum - tar exists in the map. If it does, then it means there's a subarray that sums up to tar, and we increment our result by the number of times sum - tar has occurred.
	Finally, we add the current cumulative sum sum to the map (or update its frequency) so that future elements can refer to it.
	
   Special Case:
	If the current cumulative sum sum is exactly equal to tar, it means there’s a subarray starting from the beginning of the array up to the current element that sums to tar. We handle this by directly incrementing our result (ans).
 */