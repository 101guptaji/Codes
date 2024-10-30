/*
 * Bubble sort
 * TIME Complexity: O(n*n)
 */
package javaDSA;

public class BubbleSortAlgo {
	public static void main(String[] args) {
		
		int[] arr = {7,8,1,2,3};
		int n = arr.length;
		
		//sorting by transferring highest element to end of array
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					//swap
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		//printing array
		System.out.println("Sorted array: ");
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
	}
}
