package exceptionHandle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Example1 {
    public static void main(String[] args) {
        File file1 = new File("test.txt");
        try {
            FileReader fr = new FileReader(file1);
            System.out.println("File found");
        } 
        catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("file not found " +file1);
        }

        
    }
}