package javaDSA;

import java.io.*;

public class ReverseLinkedList {
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	static void printList(Node head) {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	static Node reverseList(Node head) {
		Node next=null, curr=head, prev=null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
				
		return prev;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] list = br.readLine().split(" ");
		
		Node head = new Node(Integer.parseInt(list[0]));
		Node tail = head;
		for(int i=1;i<list.length;i++) {
			tail.next = new Node(Integer.parseInt(list[i]));
			tail = tail.next;
		}
		
		printList(head);
		
		Node newHead = reverseList(head);
		printList(newHead);
	}

}