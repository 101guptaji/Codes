package javaDSA;
import java.util.*;

public class StackUsingArrayList {
	private ArrayList<String> stack = new ArrayList<>();;
	
	private void push(String val) {
		stack.add(val);
	}
	
	private String pop() {
		if(!stack.isEmpty()) {
			return stack.removeLast();
		}
		return "";
	}
	
	private String peak() {
		if(!stack.isEmpty()) {
			return stack.getLast();
		}
		return "";
	}
	
	private void printStack() {
		for(int i=stack.size()-1;i>=0;i--) {
			System.out.println(stack.get(i));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackUsingArrayList s = new StackUsingArrayList();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 0 for push, 1 for pop, 2 for peak, 3 for print stack and -1 for stop");
		int op = sc.nextInt();
		while(op != -1) {
			switch(op) {
			case 0: 
				System.out.println("Enter element to push");
				sc.nextLine();
				String val = sc.nextLine();
				s.push(val);
				break;
			case 1:
				String ele = s.pop();
				if(ele.isEmpty())
					System.out.println("Stack is Empty");
				else
					System.out.println("Popped: " + ele);
				break;
			case 2:
				ele = s.peak();
				if(ele.isEmpty())
					System.out.println("Stack is Empty");
				else
					System.out.println("Peeked: " + ele);
				break;
			case 3:
				s.printStack();
			}
			System.out.println("Enter 0 for push, 1 for pop, 2 for peak, 3 for print stack and -1 for stop");
			op = sc.nextInt();
		}
		sc.close();
	}

}