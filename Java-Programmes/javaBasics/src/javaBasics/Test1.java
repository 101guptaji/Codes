package javaBasics;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class Test1 {

	static boolean checkPrime(long n) 
    { 
       BigInteger b = new BigInteger(String.valueOf(n)); 
        return b.isProbablePrime(1); 
    } 
    public static void main (String[] args) 
    { 
        
        int x = 44;
        BigInteger A = BigInteger.valueOf(x);
        System.out.println(A.bitCount()); // line 1
        
        BigInteger biginteger = new BigInteger("16"); 
        System.out.println(biginteger.bitLength()); 
        
        int n = 19;
        BigInteger val = BigInteger.valueOf(n); 
        System.out.println(val.nextProbablePrime()); 
    } 
}
