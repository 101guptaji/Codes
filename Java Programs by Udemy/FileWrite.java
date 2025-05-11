import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
	public static void main(String[] args) {
		File file1=new File("output.txt");
		System.out.println(file1.getAbsolutePath());
		BufferedWriter bw=null;
		try {
			FileWriter fw=new FileWriter(file1);
			bw=new BufferedWriter(fw);
			bw.write("Himanshu Gupta");
			bw.newLine();
			bw.write('7');
			bw.write("th semester");
			bw.newLine();
			bw.write("IIIT Nagpur");
		} catch (FileNotFoundException e) {
            System.out.println("File not found: " + file1.toString());
		} catch (IOException e) {
		 	System.out.println("Unable to write in file" +file1.toString() );
		}finally {
            try {
                bw.close();
            } catch (IOException e) {
                System.out.println("Unable to close file: " + file1.toString());
            }
            catch(NullPointerException ex) {
                // File was probably never opened!
            }
        }
		
		//FIle reading 
		try(BufferedReader br=new BufferedReader(new FileReader(file1))){
			
			String line;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("Unable to read in file" +file1.toString() );
		}
	}
}
