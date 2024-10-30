/*
 * Merge sort is a sorting algorithm that follows the divide-and-conquer approach. 
 * It works by recursively dividing the input array into two equal subarrays and sorting those subarrays 
 * then merging them back together to obtain the sorted array.
 * 
 * Time Complexity:
 * Average(or best) Case: θ ( N log (N))
 * Worst Case: O(N log (N))
 * 
 * Auxiliary Space: O(n)
 */
package javaDSA;

public class MergeSortAlog {
	
	//TC : O(n)
	public static void merge(int[] arr, int l, int m, int r) {
		//array to store sorted elements
		int[] merged = new int[r-l+1];
		
		// Initial indices of first and second subarrays
		int i = l;
		int j = m+1;
		
		// Initial index of merged array
		int k =0;
		
		while(i<=m && j<=r) {
			if(arr[i]<=arr[j]) {
				merged[k] = arr[i];
				i++;
				k++;
			}
			else {
				merged[k] = arr[j];
				j++;
				k++;
			}
		}
		
		// Copy remaining elements of first subarray if any
		while(i<=m) {
			merged[k] = arr[i];
			i++;
			k++;
		}
		
		// Copy remaining elements of second subarray if any
		while(j<=r) {
			merged[k] = arr[j];
			j++;
			k++;
		}
		
		//// Copy element of merged array to original array
		for(i=0,j=l;i<merged.length;i++, j++) {
			arr[j] = merged[i];
		}
	}
	
	//TC : O(logn)
	public static void sort(int[] arr, int l, int r) {
		if(l<r) {
			
			int mid = l+(r-l)/2; //not (l+r)/2 b/c (l+r) can go out of int limit
			
			//Dividing array into 2 halves and sort seperately
			sort(arr, l, mid);
			sort(arr, mid+1, r);
			
			// Merge the sorted halves
			merge(arr, l, mid, r);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {3,2,1,4,5};
		
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
