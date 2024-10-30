package arrays;

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

//Pair class
class Pair{
  int x;
  int y;
  
  public Pair(int x, int y){
      this.x = x;
      this.y = y;
  }
}


//} Driver Code Ends
//User function Template for Java
//Custom comparator class to sort the pairs
//on the basis of first element
class custom_Compare {
  
  // Compare function
  static void sortPairs(Pair arr[], int N){
      
      // Your code here
      Arrays.sort(arr, new SortbyFirst());
      //printing the x,y Pairs
      for(int i = 0;i<N;i++){
          System.out.print(arr[i].x + " " + arr[i].y + " ");
      }
      System.out.println();
  }
}

//Class 2
//Helper class extending Comparator interface
class SortbyFirst implements Comparator<Pair> {
 // Used for sorting in ascending order of first number
 public int compare(Pair o1, Pair o2) {
		if(o1.x < o2.x)
			return -1;
		else if(o1.x > o2.x)
			return 1;
		else
			return 0;
	}
 
}

//{ Driver Code Starts.

//Driver class with main function
class ArraysSortComparator {
  
  // Driver code
	public static void main (String[] args) {
		
		//taking input using Scanner class 
		Scanner sc = new Scanner(System.in);
		
		//taking count of testcases
		int testcase = sc.nextInt();
		
		while(testcase-- > 0){
		    
		    //taking count of elements
		    int N = sc.nextInt();
		    
		    // Creating an array of Pair
		    Pair arr[] = new Pair[N];
		    
		    //adding elements to Pair array
		    for(int i = 0;i<N;i++){
		        int x = sc.nextInt();
		        int y = sc.nextInt();
		        arr[i] = new Pair(x, y);
		    }
		    
		    //creating an object of custom_Compare class
		    custom_Compare obj = new custom_Compare();
		    
		    //calling sortPairs() method of
		    //class  custom_Compare
		    obj.sortPairs(arr, N);
		}
	}
}
//} Driver Code Ends