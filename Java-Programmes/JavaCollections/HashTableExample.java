import java.util.*;

public class HashTableExample {
	public static void main(String[] args) {
		
		// Initialization of a Hashtable using Generics
        Hashtable<Integer, String> ht1
            = new Hashtable<>(4, 0.75f); //initial capacity =4 and fillRatio = 0.75

        // Inserting the Elements using put() method
        ht1.put(1, "one");
        ht1.put(2, "two");
        ht1.put(3, "three");

        // Print mappings to the console
        System.out.println("Mappings of ht1 : " + ht1);
		
		System.out.println(ht1.contains(4)); 
		
		System.out.println(ht1.clone());
		
		System.out.println(ht1.size());
		
		ht1.put(3, "ThreThree");
        ht1.put(4, "four");
        ht1.put(5, "five");
        
        System.out.println(ht1.size());
		
	}
}
