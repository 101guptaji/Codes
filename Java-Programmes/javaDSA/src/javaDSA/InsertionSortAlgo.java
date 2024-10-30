/*
 * Insertion sort:
	Concept: Insertion sort builds the sorted array one element at a time. 
		It works by taking one element from the unsorted portion and inserting it into the correct position in the sorted portion.
	
	Process:
	Start with the first element as the sorted portion.
	Take the next element and compare it with elements in the sorted portion, moving the sorted elements to the right as needed to make space for the new element.
	Insert the new element in its correct position.

 * TIME Complexity: O(n*n)
 */
package javaDSA;

public class InsertionSortAlgo {
	public static void main(String[] args) {
		int[] arr = {7,8,1,2,3};
		int n = arr.length;
		
		//sorting by transferring lowest element to start of array
		for(int i=1;i<n;i++) {
			int curr = arr[i];
			int j = i;
			while(j>0 && arr[j-1] > curr) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = curr;
		}
		
		//printing array
		System.out.println("Sorted array: ");
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
}
