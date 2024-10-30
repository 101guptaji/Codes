import java.util.*;

public class TreeSetExample {

	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(5);
		ts.add(45);
		ts.add(35);
		ts.add(25);
		
		System.out.println(ts);
		
		// to check if treeset is empty or not.
        if (ts.isEmpty())
            System.out.print("Tree Set is empty.");
        else
            System.out.println("Tree Set size: " + ts.size());

        // To get the smallest element from the set
        System.out.println("First data: " + ts.first());

        // To get the largest value from set
        System.out.println("Last data: " + ts.last());

        // remove 61 from set.
        if (ts.remove(61))
            System.out.println("Data is removed from tree set");
        else
            System.out.println("Data doesn't exist!");
        
		System.out.println(ts.headSet(30)); //return elements of TreeSet which are less than 30
	}

}
