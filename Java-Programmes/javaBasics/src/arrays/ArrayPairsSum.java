package arrays;

/* Problem:
 * Given an array of N integers, and an integer K, the task is to find the number of pairs of integers in the array whose sum is equal to K.
	if no pairs are ther then print -1. Also array is distinct and sorted. 
	Note: Pairs (a,b) and (b,a)  are same. Also Pair (a,a) is not valid.
	Examples:  
	
	Input: arr[] = {1, 5, 7, -1}, K = 6
	Output:  2
	Explanation: Pairs with sum 6 are (1, 5) and (7, -1).
 */

import java.util.*;

class ArrayPairsSum
{
  static void findPairs(long arr[],int n,long sum) 
  {
       //Your code here
       /*boolean isFound = false;
       for(int i=0;i<n-1;i++){
           for(int j=i+1;j<n;j++){
               if(arr[i]+arr[j] == sum){
                   isFound = true;
                   System.out.println(arr[i]+" "+arr[j]+" "+sum);
               }
           }
       }
       if(!isFound){
           System.out.println(-1);
       }*/
	  
      Map<Long, Long> pairs = new HashMap();
      for (long i : arr) {
      	if(!pairs.containsKey(sum-i))
      		pairs.put(i, null);
      }
      for (long i : arr) {
      	if(pairs.containsKey(sum-i) && i != (sum-i)) {
      		pairs.put(sum-i,i);
      	}
      }
      
      boolean isFound = false;
      for(long k : pairs.keySet()) {
      	if(pairs.get(k) != null) {
      		isFound = true;
      		System.out.println(k+" "+pairs.get(k)+" "+sum);
      	}
      }
      if(!isFound)
      	System.out.println(-1);
  }
  
  public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    long arr[]=new long[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        long x=sc.nextLong();
		        arr[i]=x;
		    }
		    long sum=sc.nextLong();
		    findPairs(arr,n,sum);
		    
		    
		}
		
	}
}

