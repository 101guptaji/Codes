package javaBasics;

import java.io.*;
import java.util.Calendar;
import java.util.StringTokenizer;

public class FastReaderInput {

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
        // byte, short and float can be created using similar-pattern functions.
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				st = new StringTokenizer(br.readLine());
				if(st.hasMoreTokens()) {
					str= st.nextToken("\n");
				}
				else {
						str = br.readLine();
				}
			}
			 catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	
	public static void main(String[] args) {
		long startTime = Calendar.getInstance().getTimeInMillis();
		FastReader fr = new FastReader();
		// String input
        String name = fr.nextLine();

        // Character input
        char gender = fr.next().charAt(0);

        // Numerical data input
        int age = fr.nextInt();
        long mobileNo = fr.nextLong();
        double cgpa = fr.nextDouble();
        
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Total Time " + (endTime - startTime) + " ms");
        
        System.out.println("Name: "+name);
        System.out.println("Gender: "+gender);
        System.out.println("Age: "+age);
        System.out.println("Mobile Number: "+mobileNo);
        System.out.println("CGPA: "+cgpa);
	}
}
