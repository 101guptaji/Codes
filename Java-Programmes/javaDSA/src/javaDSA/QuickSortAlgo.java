/*
 * QuickSort is a sorting algorithm based on the Divide and Conquer that picks an element as a pivot and partition the array around pivot. 
 * After partition, it is ensured that all smaller elements on left and larger element than pivot on right.
 * After get index of the end point of smaller elements.
 * The left and right may not be sorted individually.
 * Recursively call for the two partitioned left and right subarrays.
 * We stop recursion when there is only one element is left.
 * 
 * First, last or any random element of array can be chosen as pivot.
 * 
 * Time Complexity:
 * Average(or best) Case: θ ( N log (N))
 * Worst Case: O(N ^ 2) When the array is already sorted and the pivot is always chosen as the smallest or largest element.
 * 
 * Auxiliary Space: O(1)
 */
package javaDSA;

public class QuickSortAlgo {
	
	// This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[high]; //pivot as last element

		// Index of smaller element 
		int i = low;
		
		for(int j=low;j<high;j++) {
			// If current element is smaller than the pivot
			if(arr[j]<pivot) {
				//swap
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				// Increment index of smaller element
				i++;
			}
		}

		//swap
		int temp = arr[i];
		arr[i] = arr[high];
		arr[high] = temp;
		
		return i;
		
	}
	
	// The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
	public static void sort(int[] arr, int low, int high) {
		if(low<high){
			
			// pi is partitioning index, arr[pi] is now at right place
			int pi = partition(arr, low, high);
			
			// Separately sort elements before
            // partition and after partition
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
		}
	}
	
	public static void main(String[] args) {
		int[] arr =  {3,4,2,1,6,5};
		
		System.out.println("Given array is");
        printArray(arr);

        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        printArray(arr);
	}
	
	// A utility function to print array of size n
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
