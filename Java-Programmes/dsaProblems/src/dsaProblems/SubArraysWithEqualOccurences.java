/*
 * Problem: Sub-arrays with equal number of occurences
 * Given an array arr[] and two integers say, x and y, find the number of sub-arrays in which the number of occurrences of x is equal to the number of occurrences of y.

    Examples:
    Input: arr[] = [1, 2, 1] , x= 1 , y = 2
    Output: 2
    Explanation: The possible sub-arrays have same equal number of occurrences of x and y are:
    1) [1, 2], x and y have same occurrence(1).
    2) [2, 1], x and y have same occurrence(1).

    Input: arr[] = [1, 2, 1] , x = 4 , y = 6
    Output: 6
    Explanation: The possible sub-arrays have same equal number of occurrences of x and y are:
    1) [1], x and y have same occurrence(0).
    2) [2], x and y have same occurrence(0).
    3) [1], x and y have same occurrence(0).
    4) [1, 2], x and y have same occurrence(0).
    5) [2, 1], x and y have same occurrence(0).
    6) [1, 2, 1], x and y have same occurrence(0).
    
    Input: arr[] = [1, 2, 1] , x= 1 , y = 4
    Output: 1
    Explanation: The possible sub-array have same equal number of occurrences of x and y is: [2], x and y have same occurrence(1)

 */
package dsaProblems;

import java.io.*;
import java.util.HashMap;

public class SubArraysWithEqualOccurences {
    
    static int sameOccurrence(int arr[], int x, int y) {
        // Initialize a HashMap to track cumulative sums 
        // and their frequencies.
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        int sum = 0;
        int ans = 0;
        freq.put(sum,1); // for empty subarray, count of x and y are equal 
        
        for(int i=0;i<arr.length;i++){
            //  Transform the array: Replace x with 1, y with -1, 
            // and other elements with 0 to represent the difference in counts.
            if(arr[i] == x){
                arr[i] = 1;
            }
            else if(arr[i] == y){
                arr[i] = -1;
            }
            else{
                arr[i] = 0;
            }
            
            //maintain a cumulative sum (sum).
            sum += arr[i];
            
            //Check if this sum has been seen before in the map. 
            //If it has, add the number of occurrences to the result (ans), indicating subarrays with equal counts of x and y.
            ans += freq.getOrDefault(sum,0);
            
            //Update the HashMap: Add or increment the count of the current sum in the map.
            freq.put(sum,freq.getOrDefault(sum,0)+1);
        }
        
        //Return ans, which contains the total number of subarrays where x and y occur equally.
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter array elements seperated by space");
        String line = br.readLine();
        String[] tokens = line.split(" ");

        // Create an Array to store the integers
        int[] arr = new int[tokens.length];

        // Parse the tokens into integers and add to the array
        for (int i=0;i<tokens.length;i++) {
            arr[i] = (Integer.parseInt(tokens[i]));
        }

        System.out.println("Enter value of x and y in seperate lines");
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        int ans = sameOccurrence(arr, x, y);
        System.out.println(ans);
    }
}
