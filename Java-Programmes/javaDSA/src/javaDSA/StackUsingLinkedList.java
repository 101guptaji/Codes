package javaDSA;

import java.util.Scanner;

class NodeStr{
	String val;
	NodeStr next;
	
	NodeStr(String val){
		this.val = val;
		this.next = null;
	}
}

public class StackUsingLinkedList {

	NodeStr head = null; 
	
	private void push(String val) {
		NodeStr newNodeStr = new NodeStr(val);
		if(head == null) {
			head = newNodeStr;
			return;
		}
		newNodeStr.next = head;
		head = newNodeStr;
	}
	
	private String pop() {
		if(head != null) {
			String popped = head.val;
			head = head.next;
			return popped;
		}
		return "";
	}
	
	private String peak() {
		if(head != null) {
			return head.val;
		}
		return "";
	}
	
	private void printStack() {
		NodeStr temp = head;
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackUsingLinkedList s = new StackUsingLinkedList();
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