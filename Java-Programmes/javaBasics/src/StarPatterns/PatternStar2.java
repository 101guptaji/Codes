package StarPatterns;

public class PatternStar2 {

	public static void main(String[] args) {
		int n=5;
		System.out.println("Pattern-1 (Butterfly)");
		/*
		 	*             * 
			* *         * * 
			* * *     * * * 
			* * * * * * * * 
			* * * * * * * * 
			* * *     * * * 
			* *         * * 
			*             * 
		 */
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			for(int j=1;j<=2*(n-i);j++) {
				System.out.print("  ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int i=n;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			for(int j=1;j<=2*(n-i);j++) {
				System.out.print("  ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println("Pattern-2 (Hollow Rhombus");
		/*
		 				* * * * * 
				      *       * 
				    *       * 
				  *       * 
				* * * * * 
		 */
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print("  ");
			}
			
			for(int j=1;j<=n;j++) {
				if(i == 1 || i == n || j == 1 || j==n)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		
		System.out.println("Pattern-3 (Diamond)");
		/*
		              * 
				    * * * 
				  * * * * * 
				* * * * * * * 
				* * * * * * * 
				  * * * * * 
				    * * * 
				      * 
		 */
		n=4;
		for(int i=1;i<=n;i++) {
			for(int j=n;j>1;j--) {
				if(j<=i)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int i=n;i>=1;i--) {
			for(int j=n;j>1;j--) {
				if(j<=i)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println("Pattern-4 (Hollow Butterfly)");
		/*
		 	*             * 
			* *         * * 
			*   *     *   * 
			*     * *     * 
			*     * *     * 
			*   *     *   * 
			* *         * * 
			*             * 
		 */
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(j==1 || j==i)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			for(int j=1;j<=n;j++) {
				if(j==n || j==n-i+1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		for(int i=n;i>=1;i--) {
			for(int j=1;j<=n;j++) {
				if(j==1 || j==i)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			for(int j=1;j<=n;j++) {
				if(j==n || j==n-i+1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		
		
	}

}
