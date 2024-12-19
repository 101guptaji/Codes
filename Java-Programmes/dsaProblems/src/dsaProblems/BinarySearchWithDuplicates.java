/*
 * Given a sorted array arr and an integer k, find the position(0-based indexing) at which k is present in the array using binary search.

    Note: If multiple occurrences are there, please return the smallest index.

    Examples:

    Input: arr[] = [1, 2, 3, 4, 5], k = 4
    Output: 3
    Explanation: 4 appears at index 3.
    Input: arr[] = [11, 22, 33, 44, 55], k = 445
    Output: -1
    Explanation: 445 is not present.
    Input: arr[] = [1, 1, 1, 1, 2], k = 1
    Output: 0
    Explanation: 1 appears at index 0.
*/
package dsaProblems;

import java.io.*;
import java.util.*;

public class BinarySearchWithDuplicates {
    public static int binarysearch(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        int l = 0, h =n-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(arr[mid] == k){
                while(mid>0 && arr[mid-1] == k){
                    mid--;
                }
                return mid;
            }
            else if(arr[mid]<k){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        sc.nextLine(); // consume the newline
        String input = sc.nextLine();
        String[] strNumbers = input.split(" ");
        int[] arr = new int[strNumbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            arr[i] = Integer.parseInt(strNumbers[i]);
        }

        int res = binarysearch(arr, k);
        System.out.println(res);

        
        sc.close();
    }
}

