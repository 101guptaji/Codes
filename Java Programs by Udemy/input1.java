import java.util.Scanner;
public class input1 {
    public static void main(String[] args) {
        
        try (//create scanner object
		var input = new Scanner(System.in)) {
			//output prompt
			System.out.println("enter your name");
			//input from user
			String name =input.nextLine();

			System.out.println("hello " + name);
		}
    }   
} 