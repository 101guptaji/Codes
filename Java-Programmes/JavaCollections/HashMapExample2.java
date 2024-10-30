import java.util.*;

public class HashMapExample2 {
	public static void main(String[] args) {
		HashMap<Integer, String> map1 = new HashMap<>();
		
		map1.put(1, "Mango");
		map1.put(2, "Apple");
		map1.put(3, "Grapes");
		
		System.out.println("HashMap1: ");
		for(Map.Entry<Integer, String> ele : map1.entrySet()) {
			System.out.println(ele.getKey()+": "+ele.getValue());
		}
		
		HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1, "Yellow");
        map2.put(3, "Red");
        map2.put(5, "Green");
 
        System.out.println("HashMap2: " + map2.toString());
        
        //Merging two maps
        map2.forEach(
        		(key, value) -> map1.merge(key, value, 
        				(v1, v2) -> v1.equalsIgnoreCase(v2) ? 
        						v1 : v1+","+v2 ));
        
        // print new mapping
        System.out.println("New HashMap: " + map1); 
        
        map1.remove(2);
        System.out.println("Map after removing 2: "+map1);
        
        
	}	
}
