import java.util.*;

public class TreeMapExample {

	public static void main(String[] args) {
		TreeMap<Character, Integer> obj = new TreeMap<>();
		obj.put('A', 1);
		obj.put('B', 2);
		obj.put('C', 3);
		System.out.println(obj.entrySet());
		
		//Example of sorting in descending order
		SortedMap<Integer, String> treeMap = new TreeMap<Integer, String>(new Comparator<Integer>() { 
                public int compare(Integer a, Integer b) 
                { 
                    return Integer.compare(b, a);
                } 
            }); 
		
		treeMap.put(new Integer(2), "practice"); 
		treeMap.put(new Integer(3), "quiz"); 
		treeMap.put(new Integer(5), "code"); 
		treeMap.put(new Integer(4), "contribute"); 
		treeMap.put(new Integer(1), "sleep"); 
		
		Set s = treeMap.entrySet(); 

		// Using iterator in SortedMap 
		Iterator i = s.iterator(); 

		// Traversing map. Note that the traversal 
		// produced sorted (by keys) output . 
		while (i.hasNext()) { 
			Map.Entry m = (Map.Entry)i.next(); 

			int key = (Integer)m.getKey(); 
			String value = (String)m.getValue(); 

			System.out.println("Key : " + key 
							+ " value : " + value); 
		}
		
		// Getting values from the tree map
        String value3 = treeMap.get(3); // O(log n)
        System.out.println("Value of 3: " + value3);

        // Removing elements from the tree map
        treeMap.remove(3); // O(log n)
        
        System.out.println("TreeMap after removing 3: ");
        // Iterating over the elements of the tree map
        for (Integer key : treeMap.keySet()) { // O(n)
            System.out.println("Key: " + key + ", Value: "+ treeMap.get(key)); // O(log n) for each get operation
        }
        //System.out.println(treeMap);
        
	}

}
