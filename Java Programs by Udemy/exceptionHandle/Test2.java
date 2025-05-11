package exceptionHandle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Test2 {
   public void filter() throws IOException, ParseException {
       //throw new IOException();

       throw new ParseException("Error at line", 2);
   }
   public void input() throws IOException , FileNotFoundException{
       
   } 
}
