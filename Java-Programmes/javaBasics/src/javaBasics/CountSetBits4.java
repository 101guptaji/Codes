package javaBasics;

/*
 * Count set bits in an integer using Lookup Table
 * Here we assume that the size of INT is 32-bits. 
 * It’s hard to count all 32 bits in one go using lookup table (” because it’s infeasible to create lookup table of size 232-1 “). 
 * So we break 32 bits into 8 bits of chunks
 * LookUp Table 
 * In lookup table, we store count of set_bit of every number that are in a range (0-255) 
 */
import java.util.Scanner;

public class CountSetBits4 {
	 // Lookup table
    static int[] BitsSetTable256 = new int[256];

    // Function to initialise the lookup table
    public static void initialize()
    {

        // To initially generate the
        // table algorithmically
        BitsSetTable256[0] = 0;
        for (int i = 0; i < 256; i++) {
            BitsSetTable256[i] = (i & 1) + BitsSetTable256[i / 2];
        }
    }

    // Function to return the count
    // of set bits in n
    public static int countSetBits(int n)
    {
        return (BitsSetTable256[n & 0xff]
                + BitsSetTable256[(n >> 8) & 0xff]
                + BitsSetTable256[(n >> 16) & 0xff]
                + BitsSetTable256[n >> 24]);
    }

    // Driver code
    public static void main(String[] args)
    {
        // Initialise the lookup table
        initialize();
        /*for(int i : BitsSetTable256)
        	System.out.print(i+" ");*/
        
        Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println("No. of sets bits: "+countSetBits(n));
    }
}

/*
	Time Complexity: O(1) 
	
	Auxiliary Space: O(1)
*/