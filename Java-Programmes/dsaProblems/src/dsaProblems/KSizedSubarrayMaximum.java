/*
 * Problem:
 * Given an array arr[] and an integer k. Find the maximum for each and every contiguous subarray of size k.

	Examples:
	Input: k = 3, arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6]
	Output: 3 3 4 5 5 5 6 
	Explanation: 
	1st contiguous subarray = [1 2 3] max = 3
	2nd contiguous subarray = [2 3 1] max = 3
	3rd contiguous subarray = [3 1 4] max = 4
	4th contiguous subarray = [1 4 5] max = 5
	5th contiguous subarray = [4 5 2] max = 5
	6th contiguous subarray = [5 2 3] max = 5
	7th contiguous subarray = [2 3 6] max = 6
	
	Input: 
	9
	83 13 23 82 20 4 83 96 88 50 93 35 5 33 25 2 93 96 32 68 17 99 60 33 14 43 84 56 38 46 67 69 47 6 32 31 71 38 89 63 31 25 72 10
	Output: 96 96 96 96 96 96 96 96 93 96 96 96 96 99 99 99 99 99 99 99 99 99 84 84 84 84 84 69 71 71 89 89 89 89 89 89

 */
package dsaProblems;

import java.io.*;
import java.util.*;

public class KSizedSubarrayMaximum {
	
	//Function to find maximum of each subarray of size k.
	public static ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
		// Your code here
		Deque<Integer> q = new LinkedList<>();
		ArrayList<Integer> res = new ArrayList<>();
	 
		/*for(int i=0;i<arr.length;i++){
			q.add(arr[i]);
			if(q.size() == k){
				int max = Collections.max(q);
				res.add(max);
				q.poll();
			}
		}*/
		
		for(int i=0;i<arr.length;i++){
			 // Remove elements from the back of the deque that are smaller than the current element
			while(!q.isEmpty() && arr[q.peekLast()] < arr[i]){
				q.pollLast();
			}
			// Add the current index to the deque
			q.add(i);
			// Remove elements from the front of the deque that are out of the current window    
			if(!q.isEmpty() && q.peek() < i-k+1){
				q.poll();
			}
			// Add the maximum element of the current window to the result
			if(i>=k-1){
				res.add(arr[q.peek()]);
			}
		}
		
		return res;
	 }

	 public static void main(String args[]) throws IOException {
	     // taking input using class Scanner
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int t = Integer.parseInt(br.readLine());
		
		 while (t-- > 0) {
		     // taking total number of elements
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
		     ArrayList<Integer> res = max_of_subarrays(k, arr);
		
		     // printing the elements of the ArrayList
		     for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
		         System.out.println();
		 }
	 }
}
