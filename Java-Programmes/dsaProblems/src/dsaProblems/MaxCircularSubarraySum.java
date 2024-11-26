/*
 * Max Circular Subarray Sum
    Difficulty: Hard
    Time Complexity: O(n)
    Auxiliary Space: O(1)
    Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get if we assume the array to be circular.

    Examples:
    Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
    Output: 22
    Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
    
    Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
    Output: 23
    Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].
    
    Input: arr[] = [-1, 40, -14, 7, 6, 5, -4, -1] 
    Output: 52
    Explanation: Circular Subarray [7, 6, 5, -4, -1, -1, 40] has the maximum sum, which is 52.
    
    Constraints:
    1 <= arr.size() <= 105
    -104 <= arr[i] <= 104
 */
package dsaProblems;

public class MaxCircularSubarraySum {
    public static int findMaxCircularSubarraySum(int arr[]){
        int totalSum = 0, curr = 0, currNeg = 0;
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;

        for(int x : arr){
            totalSum += x;
            curr = Math.max(curr+x, x);
            maxSum = Math.max(maxSum, curr);

            currNeg = Math.min(currNeg+x, x);
            minSum = Math.min(minSum, currNeg);
        }
        //if all elements are negative then answer = least negative
        if(totalSum == minSum){
            return maxSum;
        }

        //maxSum = maximum linear subarray sum
        return Math.max(maxSum, totalSum-minSum);

    }
    public static void main(String[] args) {
        int arr[] = {8, -8, 9, -9, 10, -11, 12};

        int MaxCircularSubSum = findMaxCircularSubarraySum(arr);
        System.out.println("maximum sum = "+MaxCircularSubSum);
    }
}

/*
 * Approach:
    First, find the maximum linear subarray sum in the array using Kadane's algorithm. 
    If the maximum sum is negative that means all elements in the array are negative so the maximum linear sum is the answer. 
    Otherwise, find the minimum linear subarray sum in the array and subtract it from the total sum. 
 */