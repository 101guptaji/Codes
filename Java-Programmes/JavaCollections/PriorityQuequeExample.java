//Java program to demonstrate working of 
//comparator based priority queue constructor
import java.util.*;

public class PriorityQuequeExample {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		// Creating Priority queue constructor having 
		// initial capacity=5 and a StudentComparator instance 
		// as its parameters
		PriorityQueue<Student> pq = new PriorityQueue<Student>(5, new StudentComparator());
				
		// Invoking a parameterized Student constructor with 
		// name and cgpa as the elements of queue
		Student student1 = new Student("A", 3.2);
		
		// Adding a student object containing fields 
		// name and cgpa to priority queue 
		pq.add(student1);
		Student student2 = new Student("B", 3.6);
		pq.add(student2);		 
		Student student3 = new Student("C", 4.0);
		pq.add(student3);
		
		// Printing names of students in priority order,poll()
		// method is used to access the head element of queue
		System.out.println("Students served in their priority order");
		
		while (!pq.isEmpty()) {
			System.out.println(pq.poll().getName());
		} 
			
		Deque deq = new LinkedList();
		deq.push(3);
		deq.push(4);
		deq.push(5);
				
		Iterator itr = deq.descendingIterator();
		while(itr.hasNext())
		{
		   System.out.print(itr.next() + " ");
		} 
		System.out.println();
		
		PriorityQueue  pq2  = new PriorityQueue<>();
		pq2.add(6);
		pq2.add(5);
		pq2.add(3);
		pq2.add(4);
		System.out.print(pq2.peek() + " " + pq2.size());
		
		
	}
} 

class StudentComparator implements Comparator<Student>{
			
	// Overriding compare()method of Comparator for descending order of cgpa
	public int compare(Student s1, Student s2) {
		if (s1.cgpa < s2.cgpa)
			return 1;
		else if (s1.cgpa > s2.cgpa)
			return -1;
		return 0;
	}
}

class Student {
	public String name;
	public double cgpa;
		
	// A parameterized student constructor
	public Student(String name, double cgpa) {
	
		this.name = name;
		this.cgpa = cgpa;
	}
	
	public String getName() {
		return name;
	} 
}
