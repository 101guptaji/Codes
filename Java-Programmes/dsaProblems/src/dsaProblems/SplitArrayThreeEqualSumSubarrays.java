/*
 * Split array in three equal sum subarrays
    Difficulty: Medium
    Given an array, arr[], determine if arr can be split into three consecutive parts such that the sum of each part is equal. If possible, return any index pair(i, j) in an array such that sum(arr[0..i]) = sum(arr[i+1..j]) = sum(arr[j+1..n-1]), otherwise return an array {-1,-1}.

    Note: Driver code will print true if arr can be split into three equal sum subarrays, otherwise, it is false.

    Examples :
    Input:  arr[] = [1, 3, 4, 0, 4]
    Output: true
    Explanation: [1, 2] is valid pair as sum of subarray arr[0..1] is equal to sum of subarray arr[2..3] and also to sum of subarray arr[4..4]. The sum is 4. 
    
    Input: arr[] = [2, 3, 4]
    Output: false
    Explanation: No three subarrays exist which have equal sum.
    
    Input: arr[] = [0, 1, 1]
    Output: false

    Constraints:
    3 ≤ arr.size() ≤ 106
    0 ≤ arr[i] ≤ 106
 */
package dsaProblems;

import java.io.*;
import java.util.*;

public class SplitArrayThreeEqualSumSubarrays {

    // Function to determine if array arr can be split into three equal sum sets.
    public static List<Integer> findSplit(int[] arr) {
        // code here
        long totalSum = 0;
        for(int x : arr){
            totalSum += x;
        }
        
        int i=0, j=arr.length-1;
        int lSum = arr[i];
        int rSum = arr[j];
        
        while(i<j-1){
            if(lSum == rSum && (rSum == totalSum-lSum-rSum)){
                return List.of(i,j-1);
            }
            
            if(lSum<rSum){
                i++;
                lSum += arr[i];
            }
            else{
                j--;
                rSum += arr[j];
            }
        }
        
        return List.of(-1,-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            List<Integer> result = findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
            System.out.println("~");
        }
    }
}
