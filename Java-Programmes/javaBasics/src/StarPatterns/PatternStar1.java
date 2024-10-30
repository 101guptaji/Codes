/*
 * 
 */
package StarPatterns;

public class PatternStar1 {

	public static void main(String[] args) {
		int n =5;
		System.out.println("Pattern-1 (Solid Rectangle");
		/*
		 	* * * * * 
			* * * * * 
			* * * * * 
			* * * * * 
			* * * * * 
		 */
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println("Pattern-2 (Hollow Rectangle");
		/*
		 	* * * * * 
			*       * 
			*       * 
			*       * 
			* * * * * 
		 */
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i == 0 || i == n-1 || j == 0 || j==n-1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		
		System.out.println("Pattern-3 (Half Pyramid)");
		/*
		 	* 
			* * 
			* * * 
			* * * * 
			* * * * * 
		 */
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println("Pattern-4 (Inverted Half Pyramid)");
		/*
		 	* * * * * 
			* * * * 
			* * * 
			* * 
			* 
		 */
		for(int i=0;i<n;i++) {
			for(int j=n-i-1;j>=0;j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println("Pattern-5 (Half Right side Pyramid)");
		/*
		 	        * 
			      * * 
			    * * * 
			  * * * * 
			* * * * * 
		 */
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(j>=n-i-1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		
		System.out.println("Pattern-6 (Solid Rhombus");
		/*
		 	        * * * * * 
			      * * * * * 
			    * * * * * 
			  * * * * * 
			* * * * * 
		 */
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print("  ");
			}
			
			for(int j=1;j<=n;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
