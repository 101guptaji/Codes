package Strings;

//Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class VowelConsonentCheck
{
  
	public static void main (String[] args)
	{
	    //taking input using class Scanner
  	 Scanner sc = new Scanner(System.in);
  	 
  	 //taking total count of all testcases
  	 int t = sc.nextInt();
  	 sc.nextLine();
  	 boolean flag = false;
  	 while(t-- > 0){
  	  
  	  //taking the input String
  	  String s=sc.nextLine();
  	  
  	  //Creating an object of class Geeks
  	  Geeks obj=new Geeks();
  	  
  	  //calling the checkString
  	  //method of class Geeks
  	  obj.checkString(s);
  	   
  	 }
  }
}
//} Driver Code Ends


//User function Template for Java



class Geeks{
  
  static void checkString(String s)
  {
      int v=0;
      int c=0;
      
      //Your code here
      s = s.toLowerCase();
      
      for(int i=0;i<s.length();i++) {
    	  if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'|| s.charAt(i) == 'u') {
    		  v++;
    	  }
    	  else if((s.charAt(i) > 96) && (s.charAt(i) < 123)){
    		  c++;
    	  }
      }
      
      if(v>c)
          System.out.print("Yes");
      else if(c>v)
          System.out.print("No");
      else
          System.out.print("Same");
      
      System.out.println();
  }
}

//Position this line where user code will be pasted.
