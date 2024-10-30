import java.util.*;

public class Test1 {

	public static void main(String[] args) {
		ArrayList  list = new ArrayList<>();
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(1);
		list.add(6);
		/*System.out.println(list);
		list.remove(1);
		System.out.println(list);*/
		System.out.print(Collections.binarySearch(list, 2) + " "); //undefined b/c list is not sorted
		Collections.sort(list);
		System.out.println(Collections.binarySearch(list, 2)); //return index of 2 
		
		System.out.println("Queue data: ");
		Deque deq = new LinkedList();
		deq.add(3);
		deq.add(4);
		
		Iterator itr = deq.iterator();
		while(itr.hasNext())
		{
		   System.out.print(itr.next() + " ");
		}
		System.out.println();
		deq.push(2);
		deq.push(1);
				
		Iterator itr1 = deq.iterator();
		while(itr1.hasNext())
		{
		   System.out.print(itr1.next() + " ");
		} 
		System.out.println();
		
	}

}
