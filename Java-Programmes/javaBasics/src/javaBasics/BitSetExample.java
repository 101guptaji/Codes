package javaBasics;
/*
 *Problme:
 *Java's BitSet class implements a vector of bit values (i.e.: false (0) or true (1)) that grows as needed, allowing us to easily manipulate bits while optimizing space (when compared to other collections). 
 *Any element having a bit value of 1 is called a set bit.
 *Given 2 BitSets, B1 and B2, of size N where all bits in both BitSets are initialized to 0, perform a series of M operations. 
 *After each operation, print the number of set bits in the respective BitSets as two space-separated integers on a new line. 
 * 
 * Input Format
	The first line contains 2 space-separated integers, N (the length of both BitSets B1 and B2) and  M(the number of operations to perform), respectively.
	The M subsequent lines each contain an operation in one of the following forms:
		AND <set> <set>
		OR <set> <set>
		XOR <set> <set>
		FLIP <set> <index>
		SET <set> <index>
	In the list above, <set> is the integer 1 or 2, where 1 denotes B1 and 2 denotes B2.
	 <index> is an integer denoting a bit's index in the BitSet corresponding to  <set>.
	 
	*
	*	Sample Input
		5 4
		AND 1 2
		SET 1 4
		FLIP 2 2
		OR 2 1
	* Sample Output
		0 0
		1 0
		1 1
		1 2
		
 */
import java.util.*;

public class BitSetExample {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        BitSet[] b = new BitSet[2];
        b[0] = new BitSet(n);
        b[1] = new BitSet(n);
        
        for(int i=0;i<m;i++){
            String op = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            if(op.equals("AND")){
                b[x-1].and(b[y-1]);
            }
            else if(op.equals("OR")){
                b[x-1].or(b[y-1]);
            }
            else if(op.equals("XOR")){
                b[x-1].xor(b[y-1]);
            }
            else if(op.equals("FLIP")){
                b[x-1].flip(y);;
            }
            else{
                b[x-1].set(y);
            }
            
            System.out.println(b[0].cardinality()+" "+b[1].cardinality());
        }
    }
}