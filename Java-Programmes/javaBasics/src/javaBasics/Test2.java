package javaBasics;

import java.math.BigInteger;

public class Test2 {

	static void maxValue(String str)
    {
       //Your Code here
       BigInteger num = BigInteger.valueOf(Character.getNumericValue(str.charAt(0)));
       
       for(int i=1;i<str.length();i++){
    	   BigInteger num2 = BigInteger.valueOf(Character.getNumericValue(str.charAt(i)));
    	   BigInteger sum = num.add(num2);
    	   BigInteger mul = num.multiply(num2);
    	   num = sum.max(mul);
           System.out.println(num);
       }
       System.out.println(num);
        
    }
	
	public static void main(String[] args) {
		String sr = "100";
		maxValue(sr);
	}
}
