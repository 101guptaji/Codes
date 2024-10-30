/*
 * Heap sort is a comparison-based sorting technique based on Binary Heap Data Structure. 
 * It can be seen as an optimization over selection sort where we first find the max (or min) element and swap it with the last (or first). 
 * We repeat the same process for the remaining elements.
 * 
 * Rearrange array elements so that they form a Max Heap.
	Repeat the following steps until the heap contains only one element:
	Swap the root element of the heap (which is the largest element in current heap) with the last element of the heap.
	Remove the last element of the heap (which is now in the correct position). We mainly reduce heap size and do not remove element from the actual array.
	Heapify the remaining elements of the heap.
	Finally we get sorted array.
 * 
 * Time Complexity: O(nlogn)
 */
package javaDSA;

public class HeapSortAlgo {
	public static void main(String[] args) {
		int[] arr = {2, 4, 1, 5, 3};
		int n = arr.length;
		
		//sorting using heap
		heapSort(arr,n);
		
		//printing array
		System.out.println("Sorted array: ");
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	
	//heap sort
	public static void heapSort(int[] arr, int n) {
		//building heap from array
		for(int i=n/2-1;i>=0;i--) {
			heapify(arr, n,i);
		}
		
		//swapping largest(root) element with last
		//sorting like bubble sort i.e. largest at last 
		// One by one extract an element from heap
		for(int i=n-1;i>0;i--) {
			// Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            //call max heapify on the reduced heap
            heapify(arr,i,0);
		}
	}
	
	// To heapify a subtree rooted with node i which is an index in arr[].
    // n is size of max heap
	public static void heapify(int[] arr, int n, int i) {
		int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
	}
}
