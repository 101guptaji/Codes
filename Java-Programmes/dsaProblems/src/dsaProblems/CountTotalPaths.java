/*
 * Given a 2D array of n*m. A person is standing at cell(0,0). You need to find all possible path to reach at cell(n,m);
 * The person can move either right or down of the cell.
 * Return total no. of paths possible
 * 
 */
package dsaProblems;

public class CountTotalPaths {
	public static int findPaths(int i, int j, int n, int m) {
		//border case
		if(i == n || j == m) {
			return 0;
		}
		//target cell
		if(i==n-1 && j == m-1) {
			return 1;
		}
		
		int rightPaths = findPaths(i, j+1, n, m);
		
		int downPaths = findPaths(i+1, j, n, m);
		
		return rightPaths+downPaths;
	}
	
	public static void main(String[] args) {
		int n = 3, m = 4;
		int totalPaths = findPaths(0,0,n,m);
		System.out.println("Total Paths: "+totalPaths);
	}

}
