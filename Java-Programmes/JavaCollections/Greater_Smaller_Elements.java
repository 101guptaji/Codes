/*
 * Problem:
 * Given an unsorted array A of size N and value K. The elements of the array A contain positive integers. 
 * You have to print all the elements that are greater than K in the array(including K as well if present in the array A) and print all the elements that are smaller than K in separate lines. 
 * If the elements greater than K does not present in the array then print "-1". Similarly, in case of smaller elements print -1 if elements smaller than k doesn't exist. Note that you need to sort the array, if there are duplicates print only first element.

	Input Format:
	First line of input contains number of testcases T. For each testcase, there are two lines, first of which contains N and K separated by space, next line contains N space-separated integers.
	
	Output Format:
	For each testcase, print the required elements(if any), else print "-1" (without quotes).
	
	Example:
	Input:
	1
	5 1
	2 1 5 7 6
	
	Output:
	1 2 5 6 7
	-1

 */
import java.util.*;

//{ Driver Code Starts.

//Driver class
class Greater_Smaller_Elements 
{
  // Driver code
	public static void main (String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		// Iterating over testcases
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i = 0; i < n; i++)
		      arr[i] = sc.nextInt();

		    greaterKSorted(arr, k);
		    System.out.println();
		    smallerKSorted(arr, k);
		    System.out.println();
		    //System.out.println("~");
		}
	}
	
	 // Function to find elements greater than or equal to K
    public static void greaterKSorted(int arr[], int k)
    {
    	Set<Integer> hs = new HashSet<Integer>(Arrays.stream(arr).boxed().toList());
    	System.out.println(hs);
    	
        // Your code here
        Arrays.sort(arr);
        int x = k-1;
        for(int i =0;i<arr.length;i++){
            if(arr[i] >= k && arr[i] != x){
                x = arr[i];
                System.out.print(x+" ");
            }
        }
        if(x == k-1)
            System.out.print(-1);
    }
    
    // Function to find element less than K
    public static void smallerKSorted(int arr[], int k)
    {
        // Your code here
        Arrays.sort(arr);
        int x = k+1;
        for(int i =0;i<arr.length;i++){
            if(arr[i] < k && arr[i] != x){
                x = arr[i];
                System.out.print(x+" ");
            }
        }
        if(x == k+1)
            System.out.print(-1);
    }
}
//} Driver Code Ends