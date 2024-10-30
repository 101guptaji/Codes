/*
 * You are given a class Solution and an inner class Inner.Private. The main method of class Solution takes an integer num as input. 
 * The powerof2 in class Inner.Private checks whether a number is a power of 2. 
 * You have to call the method powerof2 of the class Inner.Private from the main method of the class Solution.

	Sample Input
	8
	Sample Output
	
	8 is power of 2
	An instance of class: Solution.Inner.Private has been created
 */
package javaBasics;

import java.io.*;

public class AccessingAPrivateClass {
	public static void main(String[] args) throws Exception {	

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine().trim());
			Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private
            Inner i = new Inner();
            o = i.new Private();
            Inner.Private ip = (Inner.Private) o;
            System.out.println(num+" is "+ip.powerof2(num));
            
		System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
		
		}//end of try
		
		catch (Exception e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}//end of main
	
	static class Inner{
		private class Private{
			private String powerof2(int num){
				return ((num&num-1)==0)?"power of 2":"not a power of 2";
			}
		}
	}//end of Inner
}
