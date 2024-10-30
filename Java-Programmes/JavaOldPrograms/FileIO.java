import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileIO {

    public static void main(String[] args) throws FileNotFoundException {
        //String fileName = "/home/himanshu/Desktop/java/example.txt";
        String fileName = "example.txt";
        
        File textFile = new File(fileName);  //create file object
        
        System.out.println("File Location:" +textFile.getAbsolutePath());

        Scanner in = new Scanner(textFile); 
        int count=1;
        while(in.hasNextLine()) //checking for input at next line
        {
            String line=in.nextLine(); //getting content of line
            System.out.println(count + ":" +line);
            count++;
        }
        
        in.close();
    }

}