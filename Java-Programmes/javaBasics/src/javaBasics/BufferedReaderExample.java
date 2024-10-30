package javaBasics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class BufferedReaderExample {
	
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name = br.readLine();
		char gender = br.readLine().charAt(0);
		int age = Integer.parseInt(br.readLine());
		float cgpa = Float.parseFloat(br.readLine());
		// To read multiple value
		String[] books = br.readLine().split(" ");
		
		System.out.println("Name: "+name);
        System.out.println("Gender: "+gender);
        System.out.println("Age: "+age);
//        System.out.println("Mobile Number: "+mobileNo);
//        System.out.println("Total Marks: "+totalMarks);
        System.out.println("CGPA: "+cgpa);
	}
}
