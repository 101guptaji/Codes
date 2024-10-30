/*
 * Selection sort
 * TIME Complexity: O(n*n)
 */
package javaDSA;

public class SelectionSortAlgo {

	public static void main(String[] args) {
		int[] arr = {7,8,1,2,3};
		int n = arr.length;
		
		//sorting by transferring lowest element to start of array
		for(int i=0;i<n-1;i++) {
			int smallIndex = i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[smallIndex]) {
					smallIndex = j;
				}
			}
			//swap
			int temp = arr[i];
			arr[i] = arr[smallIndex];
			arr[smallIndex] = temp;
		}
		
		//printing array
		System.out.println("Sorted array: ");
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}

}
