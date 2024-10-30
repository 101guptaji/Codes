package Strings;
/*
 * Problem:
 * You are given a string s of x and y. You need to verify whether the string follows the pattern xnyn. 
 * That is the string is valid only if equal number of ys follow equal number of xs.
	As an example: xxyyxxyy is valid. xy is valid. xxyyx is invalid. xxxyyyxxyyxy is valid.
 */
import java.util.*;
import java.util.regex.*;

public class PatternMatcher
{
  
	public static void main (String[] args)
	{
	     //Taking input using Scanner class
	  	 Scanner sc = new Scanner(System.in);
	  	 
	  	 //taking count of total testcases
	  	 int t = sc.nextInt();
	  	 
	  	 while(t-- > 0){
	  	   //taking the String
	  	   String s=sc.next();
	  	   
	  	   //calling follPatt() method
	  	   // and passing
	  	   //String as parameter
	  	   follPatt(s);
	  	   
  	 }
  }
  
  static void follPatt(String s)
  {
      //Your code here
	  int xCount =0, yCount = 0;
      boolean isFollow = true;
      for(int i=0;i<s.length();i++){
          if(s.charAt(i) == 'x'){
              if(isFollow && xCount != yCount)
                  break;
              isFollow = false;
              xCount++;
          }
          else{
              yCount++;
              isFollow = true;
          }
      }
      if(isFollow && xCount == yCount){
           System.out.println(1);
      }
      else
           System.out.println(0);
  }
}
