
import java.io.*;
import java.util.*;

class QueuePatternPrint {
	
	 static void patternPrint(Queue<Character>q)
	  {
	     //Your code here
	     /*while(!q.isEmpty()) {
	    	 char clast = ((LinkedList<Character>) q).getLast();
	    	 System.out.print(q.poll()+""+clast);
	    	 q.remove(clast);
	     }*/ 
		 Object[] cArr = q.toArray();
		 int n =cArr.length;
		 for(int i=0;i<n/2;i++) {
			 System.out.print(cArr[i]+""+cArr[n-i-1]);
		 }
		 if(n%2 != 0) {
			 System.out.print(cArr[n/2]);
		 }
	  }
	
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    String s=sc.next(); //Taking string as input
		    Queue<Character>q=new LinkedList<>();
		    for(int i=0;i<s.length();i++)
		    {
		        q.add(s.charAt(i)); //Putting s into a queue
		    }

		    patternPrint(q); //passing queue to the function that you need to complete
		    System.out.println();  //new line already added, don't add.
		}
	}
}

