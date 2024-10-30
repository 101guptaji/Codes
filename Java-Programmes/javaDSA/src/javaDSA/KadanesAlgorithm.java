/*
 * Given an integer array arr[]. You need to find and return the maximum sum possible from all the subarrays.

    Examples:
    Input: arr[] = [1, 2, 3, -2, 5]
    Output: 9
    Explanation: Max subarray sum is 9 of elements (1, 2, 3, -2, 5).
    Input: arr[] = [-1, -2, -3, -4]
    Output: -1
    Explanation: Max subarray sum is -1 of element (-1).
    Input: arr[] = [5, 4, 7]
    Output: 16
    Explanation: Max subarray sum is 16 of elements (5, 4, 7)
    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(1)
 */
package javaDSA;

public class KadanesAlgorithm {
    
    // Function to find the sum of contiguous subarray with maximum sum.
    static int maxSubarraySum(int[] arr) {
        // Your code here
        
        int maxSum = arr[0];
        int sum = 0;
        for(int x : arr){
            sum += x;
            
            maxSum = Math.max(sum, maxSum);
            
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        System.out.println(maxSubarraySum(arr));
    }
}

/*
 * Approach: 
 *  This problem involves finding the contiguous subarray within a given array that has the maximum sum. 
 *  We can efficiently solve this problem using the Kadane's algorithm, which iterates through the array, 
 *  keeping track of the current maximum sum and the overall maximum sum encountered so far.
    Key Idea: 
    The algorithm maintains a current_sum variable to store the sum of the current subarray.
    As we iterate through the array:
    If the current_sumbecomes negative, we discard it and start a new subarray from the current element.
    Otherwise, we update the current_sum by adding the current element.
    We continuously update the max_sum variable with the maximum of current_sum and the previously stored max_sum.
 */
