package javaBasics;

import java.util.*;

public class CountPositiveNegative {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int pos=0,neg=0,zero=0;
			while(sc.hasNextInt()) {
				int n = sc.nextInt();
				if(n>0)
					pos++;
				else if(n<0)
					neg++;
				else
					zero++;
			}
			System.out.println("Positives are:"+pos);
			System.out.println("Negatives are:"+neg);
			System.out.println("Zeross are:"+zero);
		}
		finally {
			sc.close();
		}

	}

}
