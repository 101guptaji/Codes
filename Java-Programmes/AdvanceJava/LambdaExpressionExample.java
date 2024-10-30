/*
 * Write the following methods that return a lambda expression performing a specified action:

	PerformOperation isOdd(): The lambda expression must return true if a number is odd or false if it is even.
	PerformOperation isPrime(): The lambda expression must return true if a number is prime or false if it is composite.
	PerformOperation isPalindrome(): The lambda expression must return true if a number is a palindrome or false if it is not.
	
	Input Format:
	Input is handled for you by the locked stub code in your editor.
	
	Output Format:
	The locked stub code in your editor will print T lines of output.
	
	Sample Input
	The first line contains an integer, T (the number of test cases).
	The T subsequent lines each describe a test case in the form of 2 space-separated integers:
	The first integer specifies the condition to check for (1 for Odd/Even, 2 for Prime, or 3 for Palindrome). 
	The second integer denotes the number to be checked.
	
	Sample Input:
	5
	1 4
	2 5
	3 898
	1 3
	2 12
	
	Sample Output
	EVEN
	PRIME
	PALINDROME
	ODD
	COMPOSITE
 */

import java.io.*;
import java.util.*;
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	  }

   // Write your code here
   PerformOperation isOdd(){
       PerformOperation po = (int a)->(a%2 != 0)? true : false;
       return po;
   }
   
   PerformOperation isPrime(){
       return (int a)->{
           if (a <= 1) return false;
           for (int i = 2; i <= Math.sqrt(a); i++) {
               if (a % i == 0) return false;
           }
           return true;
       };
   }
   
   PerformOperation isPalindrome(){
       return (int a)->{
    	   String str = Integer.toString(a);
           //System.out.println(str);
           int n = str.length();
           for(int i=0;i<n/2;i++){
               if(str.charAt(i) != str.charAt(n-i-1)){
                   return false;
               }
           }
           return true;
       };
   }
}

public class LambdaExpressionExample {
	 public static void main(String[] args) throws IOException {
	  MyMath ob = new MyMath();
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  int T = Integer.parseInt(br.readLine());
	  PerformOperation op;
	  boolean ret = false;
	  String ans = null;
	  while (T--> 0) {
	   String s = br.readLine().trim();
	   StringTokenizer st = new StringTokenizer(s);
	   int ch = Integer.parseInt(st.nextToken());
	   int num = Integer.parseInt(st.nextToken());
	   if (ch == 1) {
	    op = ob.isOdd();
	    ret = ob.checker(op, num);
	    ans = (ret) ? "ODD" : "EVEN";
	   } else if (ch == 2) {
	    op = ob.isPrime();
	    ret = ob.checker(op, num);
	    ans = (ret) ? "PRIME" : "COMPOSITE";
	   } else if (ch == 3) {
	    op = ob.isPalindrome();
	    ret = ob.checker(op, num);
	    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
	
	   }
	   System.out.println(ans);
	  }
	 }
}

