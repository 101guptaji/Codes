

import java.util.*;

class TestDictionary 
{
  
  @SuppressWarnings("unchecked")
	public static void main (String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
	    Dictionary dn = new Hashtable();
	    int n = sc.nextInt();
	    int pages[] = new int[n];
	    String words[] = new String[n];
	    for(int i = 0; i < n; i++)
	       pages[i] = sc.nextInt();
	        
      for(int i = 0; i < n; i++)
          words[i] = sc.next();
	    for(int i = 0; i < n; i++)
	     dn.put(pages[i], words[i]);
	     
	    int pg = sc.nextInt();
	   checkEmpty(dn, pg);
		
	}
  
  public static void checkEmpty(Dictionary dn, int  pg)
  {
      //Your code here
     if(dn.isEmpty()) {
    	 System.out.println("Empty");
     }
     else {
    	 System.out.println(dn.remove(pg));
     }
     
  }
}
