/*
 * Find total of ways to place tiles of size 1*m in a floor of size n*m such that whole floor get full of tiles.
 * 
 */
package dsaProblems;

public class PlaceTilesInFloor {
	public static int placeTiles(int n, int m) {
		//either all horizontally or vertically
		if(n == m) {
			return 2;
		}
		//only horizontal is possible
		if(n<m) {
			return 1;
		}
		
		int horizontalPalce = placeTiles(n-1, m);
		
		int verticalPlace = placeTiles(n-m, m);
		
		return horizontalPalce+verticalPlace;
	}
	
	public static void main(String[] args) {
		int n = 4, m = 2;
		int totalWays = placeTiles(n,m);
		System.out.println("Total possible ways: "+totalWays);
	}
}
