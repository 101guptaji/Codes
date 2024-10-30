package arrays;

/*
 * Given an array of integers. All numbers occur twice except one number which occurs once. Find the number in O(n) time & constant extra space.

	Example : 	
	Input:  arr[] = {7, 3, 5, 4, 5, 3, 4}
	Output: 7 
	One solution is to check every element if it appears once or not. Once an element with a single occurrence is found, return it. Time complexity of this solution is O(n2).
	
	A better solution is to use hashing. 
		Traverse all elements and put them in a hash table. Element is used as key and the count of occurrences is used as the value in the hash table. 
		Traverse the array again and print the element with count 1 in the hash table. 
	This solution works in O(n) time but requires extra space.
	
	The best solution is to use XOR. XOR of all array elements gives us the number with a single occurrence. The idea is based on the following two facts. 
	 	XOR of a number with itself is 0. 
		XOR of a number with 0 is number itself.
 */

public class FindSingleElement {
	
	static int findSingle(int[] arr) {
		int res = arr[0];
		// Do XOR of all elements and return
		for(int i =1;i<arr.length;i++) {
			res = res ^ arr[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = {2, 3, 5, 4, 5, 3, 4}; //{7,5,3,6,5,6,3};
		
		 System.out.println("Element occurring once is: " + findSingle(arr) + " ");
		 
	}

}
