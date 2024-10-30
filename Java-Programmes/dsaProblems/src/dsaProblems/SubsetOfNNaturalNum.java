/*
 * Find all the subsets of a set of first n  natural numbers
 * E.g. 
 * n=2 -> 1,2,(1,2)
 */
package dsaProblems;
import java.util.*;

public class SubsetOfNNaturalNum {
	public static void findSubset(int n, ArrayList<Integer> arr) {
		if(n == 0) {
			System.out.println(arr.toString());
			return;
		}
		
		//add n
		arr.add(n);
		findSubset(n-1, arr);
		
		//don't add n;
		arr.remove(arr.size()-1);
		findSubset(n-1, arr);
	}
	
	public static void main(String[] args) {
		int n =3;
		findSubset(n, new ArrayList<Integer>());

	}

}
