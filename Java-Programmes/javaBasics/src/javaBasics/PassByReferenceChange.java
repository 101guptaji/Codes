package javaBasics;
/*
 * if we set some other reference to object passed inside method, the object from calling method as well its reference will remain unaffected. 
 * The changes are not reflected back if we change the object itself to refer some other location or object.
 */
public class PassByReferenceChange {

	// swap() doesn't swap i and j
	   public static void swap(Integer i, Integer j) 
	   {
	      Integer temp = new Integer(i);
	      i = j;
	      j = temp;
	      //System.out.println("i = " + i + ", j = " + j+",temp "+temp);
	   }
	   public static void main(String[] args) 
	   {
	      Integer i = new Integer(10);
	      Integer j = new Integer(20);
	      swap(i, j);
	      System.out.println("i = " + i + ", j = " + j);
	   }
}
