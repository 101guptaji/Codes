/* 
 * Problem: 
 * Given an unsorted array of integers arr[], and a target tar, 
 * determine the number of subarrays whose elements sum up to the target value.

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
package dsaProblems;

import java.io.*;
import java.util.*;

public class SubArraysSumToK {

    // Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int k) {
        //
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int count = 0;
        for(int x : arr){
            sum += x;
            if(sum == k){
                count++;
            }

            //sum(i,j) = sum(j)-sum(i-1) where sum(j) = sum of array elements from index 0 to j
            //So, if sum(i,j) == k then k = sum(j)-sum(i-1) => sum(i-1) = sum(j)-k
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return count;

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

        int res = subArraySum(arr, tar);

        System.out.println(res);
        
    }
}
/*
 * sum(i) = sum(j)-sum(i-1) where sum(i) = sum of array elements from index 0 to i
 * So, if sum(i) == k then k = sum(j)-sum(i-1) -> sum(i-1) = sum(j)-k
 */