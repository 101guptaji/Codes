import java.util.*;

public class CollectionClassExample {
	public static void main(String[] args) throws Exception{
		List orgList = new ArrayList();
		orgList.add("Apple");
		orgList.add("Orange");
		orgList.add("Mango");
		System.out.println(orgList);
		
		 // Adding one or more elements using addAll() 
		Collections.addAll(orgList, "Grapes","Papaya");
		System.out.println(orgList);
		
		// Sorting according to default ordering 
        // using sort() method 
		Collections.sort(orgList);
		System.out.print("After sorting in default order: ");
		for (int i = 0; i < orgList.size(); i++) { 
            System.out.print(orgList.get(i) + ", "); 
        } 
        System.out.println(); 
        
        // BinarySearch on the List 
        System.out.println("The index of Grapes is "+Collections.binarySearch(orgList, "Grapes"));
        
        
        // BinarySearch on the List for element not in list
        //return the possible negative position of searched element -1 (i.e. -pos-1)
        System.out.println("The index of Banana is "+Collections.binarySearch(orgList, "Banana"));
        
        // Sorting according to reverse ordering 
		Collections.sort(orgList, Collections.reverseOrder());
		
		// Iterator to iterate through collection elements
		Iterator itr =orgList.iterator();
		System.out.print("After sorting in reverse order: ");
		while(itr.hasNext()) { 
            System.out.print(itr.next() + ", "); 
        } 
        System.out.println();
        //System.out.println(ll);
        
        //Copying Elements Using copy() method 
        List<String> srcList = new ArrayList<String>();
        srcList.add("Tiger");
        srcList.add("Lion");
        srcList.add("Bear");
        //srcList.set(2,5);
        Collections.copy(orgList, srcList);
        System.out.println("After copying animal list to fruit list: "+orgList);
        
        
        
	}
}
