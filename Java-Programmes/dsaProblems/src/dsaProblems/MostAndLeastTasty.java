/*
 * Problem: 
 * Geek has K friends and their birthday is coming up. Geek has N Chocolates as a sequence called Arr(each Arri denoting taste of ith Chocolate) 
 * and he wants to gift these to his friends on their birthday. He need to partition the sequence to gift all of them, where the taste of making 
 * a partition from l to r is Arrl + Arrr. 
 * Find the difference between amount of most and least taste of chocolates of making exactly K partitions where the total taste is the 
 * sum of taste of each partition.
 * Example 1:
	Input:
	N = 4, K = 2
	Arr = {1, 2, 3, 1}
	Output: 2
	Explaination: If we partition like
	this -> 1 | 2 3 1 
	For the first partition: l = 1 and r = 1
	For the second partition: l = 2 and r = 4
	then we will get
	minimum taste = (taste of 1st partition) + (taste of 2nd partition) 
	              = (Arr[1]+Arr[1]) + (Arr[2]+ Arr[4])
	              = (1+1) + (2+1) = 5 
	and If we partition like this -> 
	1 2 | 3 1 then we will get
	maximum taste = (1+2)+(3+1) = 7.
	So difference is 7 - 5 = 2. 
	
	Example 2:
	Input:
	N = 5, K = 2 
	Arr = {1, 2, 3, 4, 5}
	Output: 6
	Explaination: If we partition like
	this -> 1 | 2 3 4 5 then we will get
	minimum taste = 1+1+2+5 = 9 and
	If we partition like this ->
	1 2 3 4 | 5 then we will get
	maximum taste = 1+4+5+5 = 15.
	So difference is 15 - 9 = 6.
 */

package dsaProblems;

import java.io.*;
import java.util.*;

class MostAndLeastTasty{
  public static void main(String args[])throws IOException
  {
      BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(read.readLine());
      while(t-- > 0)
      {
          String[] s = read.readLine().trim().split(" ");
          int N = Integer.parseInt(s[0]);
          int K = Integer.parseInt(s[1]);
          String input_line[] = read.readLine().trim().split("\\s+");
          int Arr[]= new int[N];
          for(int i = 0; i < N; i++)
              Arr[i] = Integer.parseInt(input_line[i]);
          
          System.out.println(diffInTaste(N,K,Arr));
      }
  }
  
  public static long diffInTaste(int n, int k, int arr[])
  {
      // code here
      if(k>=n)
          return 0;
          
      List<Integer> li = new ArrayList<Integer>();
      for(int i=0;i<n-1;i++){
          li.add(arr[i]+arr[i+1]);
      }
      Collections.sort(li);
      
      long min = arr[0], max = arr[0];
      for(int i=0;i<k-1;i++){
          min+=li.get(i);
      }
      
      n = li.size();
      for(int i=0;i<k-1;i++){
          max+=li.get(n-i-1);
      }
      return max-min;
  }
}






