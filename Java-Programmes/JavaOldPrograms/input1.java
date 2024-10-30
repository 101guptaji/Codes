import java.util.Scanner;
public class input1 {
    public static void main(String[] args) {
        
        //create scanner object
        Scanner input = new Scanner(System.in);
        //output prompt
        System.out.println("enter your name");
        //input from user
        String name =input.nextLine();

        System.out.println("hello " + name);
    }   
} 