package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestArray {
	
	public static void main(String[] args) {
		long arr[] = new long[] {1,3,5,7,8,10};
		
		for(long x : arr) {
			if(x % 2 == 0) {
				System.out.print(x+" ");
			}
		}
	}
}
