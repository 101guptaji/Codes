/** Problem
 * Given an array of size N and a sum, the task is to check whether some array elements can be added to sum to N . 
Note: At least one element should be included to form the sum.(i.e. sum cant be zero) 
Examples: 
 

Input: array = -1, 2, 4, 121, N = 5
Output: YES
The array elements 2, 4, -1 can be added to sum to N

Input: array = 1, 3, 7, 121, N = 5
Output:NO 
 */
package arrays;

/**
 * Approach: The idea is to generate  all subsets of array and correspondingly check if any subset has the sum equal to the given sum.
 */
public class SubsetArraySum {

	static void find(int[] arr, int len, int s) {
		
		/*for(int i=0;i<len-1;i++) {
			int sum = arr[i];
			for(int j=i+1;j<len;j++) {
				sum += arr[j];
				if(sum == s) {
					System.out.println("YES");
                    return;
				}
			}
		}*/
		
		// loop for all 2^n combinations
        for (int i = 1; i <= (Math.pow(2, len)); i++) {
    
            // sum of a combination
            int sum = 0;
    
            for (int j = 0; j < len; j++) {
                // if the bit is 1 then add the element
            	int x = (i >> j);
            	//System.out.printf("%d %d %d\n",i,j,x);
                if ((x & 1) == 1) {	
                    sum += arr[j];
                    //System.out.println(sum);
                }
            }
            // if the sum is equal to given sum print yes
            if (sum == s) {
                System.out.println("YES");
                return;
            }
        }
		System.out.println("NO");
	}
	
	
	public static void main(String[] args) {
		 int sum = 5;
         int []array = { -1, 2, 121, 4 };
         int length = array.length;
     
         // find whether it is possible to sum to n
         find(array, length, sum);

	}

}
