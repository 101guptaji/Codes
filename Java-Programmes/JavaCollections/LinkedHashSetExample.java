import java.util.*;

public class LinkedHashSetExample {

	public static void main(String[] args) {
		Set<Integer> setA = new LinkedHashSet<>();
		//adding 
		setA.add(2);
		setA.add(3);
		setA.add(5);
		setA.add(1);
		setA.add(3); //duplicate element not allowed
		
		System.out.println("Origional set: "+setA);
		
		//removing
		setA.remove(5);
		System.out.println("set after removing 5: "+setA);
		
		//iterating
		for(Iterator it = setA.iterator();it.hasNext();) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
		
		//iteration through for each loop
		for(int x : setA) {
			System.out.print(x+" ");
		}
		System.out.println();
	}
}
