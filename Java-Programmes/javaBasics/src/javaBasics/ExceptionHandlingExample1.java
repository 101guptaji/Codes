package javaBasics;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingExample1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			System.out.println(x/y);
		}
		catch(InputMismatchException i) {
			i.printStackTrace();
		}
		catch(ArithmeticException e) {
			System.out.println(e.toString());
		}
		finally {
			sc.close();
		}
	}

}
