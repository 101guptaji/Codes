package exceptionHandle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class MultiException {
   public static void main(String[] args) {
      Test2 test = new Test2();

      //multi-catch block
      try {
         test.filter();
      } catch (IOException | ParseException e) {
         //e.printStackTrace();
         System.out.println("Multi-catch Exception");
      }
      //multiple catch blocks
      try {
         test.filter();
      } catch (IOException e) {
         System.out.println("IO Exception");
         //e.printStackTrace();
      } catch (ParseException e) {
         System.out.println("Parse Exception");
         //e.printStackTrace();
      }
      // Using polymorphism to catch the parent of all exceptions
        try {
            test.filter();
        } catch (Exception e) {
            System.out.println("An Exception");
            //e.printStackTrace();
        } 
        // Important to catch exceptions in the right order!
        // IOException cannot come first, because it's the parent
        // of FileNotFoundException, so would catch both exceptions
        // in this case.
        try {
            test.input();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   } 
}
