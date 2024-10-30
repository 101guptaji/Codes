package Strings;

//Java Program to implement Java String Tokenizer Constructors and methods
import java.util.*;

//Driver Class
class StringTokenizerExample {
	// main function
	public static void main(String[] args)
	{
		// Constructor 1
		System.out.println("Using Constructor 1 - ");

		// Creating object of class inside main() method
		StringTokenizer st1 = new StringTokenizer(
			"Hello Geeks How are you", " ");

		// Condition holds true till there is single token
		// remaining using hasMoreTokens() method
		while (st1.hasMoreTokens())
			// Getting next tokens
			System.out.println(st1.nextToken());

		// Constructor 2
		System.out.println("Using Constructor 2 - ");

		// Again creating object of class inside main()
		// method
		StringTokenizer st2 = new StringTokenizer(
			"JAVA : Code : String", " :");

		// If tokens are present
		while (st2.hasMoreTokens())

			// Print all tokens
			System.out.println(st2.nextToken());

		// Constructor 3
		System.out.println("Using Constructor 3 - ");

		// Again creating object of class inside main()
		// method
		StringTokenizer st3 = new StringTokenizer(
			"JAVA : Code : String", " :", true);
		
		 // countTokens Method
        int count = st3.countTokens();
        System.out.println(count);
        
		while (st3.hasMoreTokens())
			System.out.println(st3.nextToken());
		
		 // countTokens Method
        int count1 = st3.countTokens();
        System.out.println(count1);
	}
}
