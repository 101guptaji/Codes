import java.util.*;

public class SetUnion {
	
	public static void main(String[] args) {
		Set<Integer> setA = new HashSet<Integer>();
		
		setA.addAll(Arrays.asList(
				new Integer[] {2,4,6,8,10,12}));
		
		Set<Integer> setB = new HashSet<Integer>(Arrays.asList(
				new Integer[] {3,6,9,12,15}));
		
		System.out.println("Set A: "+setA);
		System.out.println("Set B: "+setB);
		
		//to find Union
		Set<Integer> union = new HashSet<>(setA);
		union.addAll(setB);
		System.out.println("Union of set A and B: "+union);
		
		//to find Intersection
		Set<Integer> intersect = new HashSet<>(setA);
		intersect.retainAll(setB);
		System.out.println("Intersection of set A and B: "+intersect);
		
		//to find difference 
		Set<Integer> diff = new HashSet<>(setA);
		diff.removeAll(setB);
		System.out.println("Difference of set A to B (A-B): "+diff);
	}
	
}
