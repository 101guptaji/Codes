package StarPatterns;

public class PatternNumber2 {
	static int factorial(int i) {
		if(i==0) {
			return 1;
		}
		return i * factorial(i-1);
	}
	
	public static void main(String[] args) {
		int n=5;
		System.out.println("Pattern-1 (Pascal Triangle)");
		/*
		  	1
		   1 1
		  1 2 1
		 1 3 3 1
		1 4 6 4 1
		 */
		for(int i=0;i<n;i++) {
			for(int j=1;j<n-i;j++) {
				System.out.print(" ");
			}
			/*for(int j=0;j<=i;j++) {
				//using nCr formula: n ! / ( n – r ) ! r ! 
				System.out.print(" "+factorial(i)/(factorial(i-j)*factorial(j)));
			}*/

			int value = 1; // Starting value for each row
            for (int j = 0; j <= i; j++) {
                System.out.print(value + " ");
                value = value * (i - j) / (j + 1); // Update value based on Pascal's formula
            }
			System.out.println();
		}
		
		System.out.println("Pattern-2 (half Pyramid)");
		/*
		  	1
		   1 2
		  1 2 3
		 1 2 3 4
		1 2 3 4 5
		 */
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) { 
				System.out.print(" "+j);
			}
			System.out.println();
		}
		
		System.out.println("Pattern-3 (Inverted half Pyramid)");
		/*
		 1 1 1 1 1
		  2 2 2 2
		   3 3 3
		    4 4
		     5
		 */
		for(int i=n;i>=1;i--) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) { 
				System.out.print(" "+(n-i+1));
			}
			System.out.println();
		}
	}
}
