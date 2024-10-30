package StarPatterns;

public class PatternNumber {

	public static void main(String[] args) {
		int n = 5;
		System.out.println("Pattern-1 (Half Pyramid)");
		/*
			1 
			1 2 
			1 2 3 
			1 2 3 4 
			1 2 3 4 5 
		 */
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		System.out.println("Pattern-2 (iNVERTED Half Pyramid)");
		/*
		 	1 2 3 4 5 
			1 2 3 4 
			1 2 3 
			1 2 
			1 
		 */
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i+1;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		System.out.println("Pattern-3 (Floyd's Triangle)");
		/*
		 	1 
			2 3 
			4 5 6 
			7 8 9 10 
			11 12 13 14 15 
		 */
		int count=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print((count++)+" ");
			}
			System.out.println();
		}
		
		System.out.println("Pattern-4 (0-1 Triangle)");
		/*
		  	1 
			0 1 
			1 0 1 
			0 1 0 1 
			1 0 1 0 1 
		 */
		for(int i=1;i<=n;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(((i+j)%2)+" ");
			}
			System.out.println();
		}
		
		System.out.println("Pattern-5 (centered pyramid)");
		/*
		  	 1
		    2 2
		   3 3 3
		  4 4 4 4
		 5 5 5 5 5
		 */
		for(int i=1;i<=n;i++) {
			for(int j=0;j<n-i;j++) {
				System.out.print(" ");
			}
			
			for(int j=0;j<i;j++) {
				System.out.print(" "+i);
			}
			System.out.println();
		}
		
		System.out.println("Pattern-6 (Palindrom number Pyramid)");
		/*
		        1 
		      2 1 2 
		    3 2 1 2 3 
		  4 3 2 1 2 3 4 
		5 4 3 2 1 2 3 4 5 
		 */
		for(int i=1;i<=n;i++) {
			for(int j=n;j>1;j--) {
				if(j<=i)
					System.out.print(j+" ");
				else
					System.out.print("  ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

}
