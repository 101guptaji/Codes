/*
 * Find total of ways of inviting n people in a party, either single or in pairs.
 * For Example:
 * n=1 -> only one way i.e invite single
 * n=2 -> (1, 2), (1-2) -> 2 ways
 * n=3 -> (1,2,3), (1-2, 3), (1-3,2), (1,2-3) -> 4 ways
 */
package dsaProblems;

public class GuestsCall {
	public static int callGuests(int n) {
		if(n<=1) {
			return 1;
		}
		
		//n is called single
		int single = callGuests(n-1);
		
		//n is called in pair
		int pairs = (n-1)*callGuests(n-2);
		
		return single+pairs;
	}
	
	public static void main(String[] args) {
		int n =4;
		int totalWays = callGuests(n);
		System.out.println(totalWays);
	}

}