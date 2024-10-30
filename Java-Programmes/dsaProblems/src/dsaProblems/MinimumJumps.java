/*
 * Minimum Jumps
    Difficulty: Medium
    Given an array arr[] of non-negative integers. Each array element represents the maximum length of the jumps that can be made forward from that element. This means if arr[i] = x, then we can jump any distance y such that y ≤ x. Find the minimum number of jumps to reach the end of the array starting from the first element. If an element is 0, then you cannot move through that element.

    Note:  Return -1 if you can't reach the end of the array.

    Examples : 

    Input: arr[] = [1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]
    Output: 3 
    Explanation: First jump from 1st element to 2nd element with value 3. From here we jump to 5th element with value 9, and from here we will jump to the last. 
    Input: arr = [1, 4, 3, 2, 6, 7]
    Output: 2 
    Explanation: First we jump from the 1st to 2nd element and then jump to the last element.
    Input: arr = [0, 10, 20]
    Output: -1
    Explanation: We cannot go anywhere from the 1st element.
 */
package dsaProblems;

public class MinimumJumps {

    static int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1){ // If we are already at the last element
            return 0;
        }
        if(arr[0] == 0){ // Can't move from the first element
            return -1;
        }
        
        int jumps = 0;
        int maxDist = 0; // Farthest point we can reach
        int currDist = 0; // The end of the range for the current jump
        
        for(int i=0;i<n-1;i++){
            
            // Update the farthest point we can reach
            maxDist = Math.max(maxDist, i+arr[i]);
            
            // If we reached the end of the current jump range
            if(i == currDist){
                jumps++;
                currDist = maxDist; // Set the next jump's range end
                
                 // If the next jump's range is beyond the last element
                if(currDist >= n-1)
                    return jumps;
            }
        }
        
        return -1; // If no solution is found
    }

    public static void main(String[] args) {
        int arr[] = {9, 10, 1, 2, 3, 4, 8, 0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(minJumps(arr));
    }
}
