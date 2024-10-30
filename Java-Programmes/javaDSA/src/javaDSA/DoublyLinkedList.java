package javaDSA;

import java.util.Scanner;

/*Doubly Linked List
 Doubly linked list, an extension of singly linked list allows us to store not only a next pointer, but also a previous pointer. Therefore, every node points to it's next and previous node.
 This provides us benefits like traversing back and forth but the trade-off is extra space. We need to maintain an extra pointer for every node.
 The structure of the node now is:
	1. Datatype value
	2. node next
	3. node prev
 Note - The prev pointer of head is null and the next pointer of the tail is null.
 Some applications of Doubly Linked List are:
	1. Implementing LRU (Least Recently Used) cache algorithm
	2. Used in applications where undo redo use-cases are applicable
	3. Deletion operation in O(1) time using map.
 * 
 */

public class DoublyLinkedList {
	public class Node{
		int value;
		Node next, prev;
		
		public Node(int val)
		{
			value = val;
			next = null;
			prev = null;
		}
	}
	
	Node head;
	
	public DoublyLinkedList() {
		head = null;
	}
	
	//insert new element at index-th position
	void insertAtIndex(int index, int value) {
	    Node newNode = new Node(value);

	    if (index == 0) {
	        // To insert at head, make this new node the head
	        newNode.next = head;
	        if (head != null) {
	            head.prev = newNode;
	        }
	        head = newNode;
	    } 
	    else {
	        // To insert at any other position
	        // Find the nodes between which we want to insert
	        // By traversing from head to index - 1 position
	        Node iter = head;
	        for (int i = 0; i < index - 1; i++) {
	            iter = iter.next;
	        }

	        Node A = iter;
	        Node B = iter.next;

	        // Update pointers to insert newNode between A and B
	        A.next = newNode;
	        if (B != null) {
	            B.prev = newNode;
	        }

	        // Update pointers of newNode
	        newNode.next = B;
	        newNode.prev = A;
	    }
	}
	
	//delete the node
	void deleteNode(int value) {
	    Node targetNode = head;
	    while (targetNode != null && targetNode.value != value) {
	        targetNode = targetNode.next;
	    }

	    if (targetNode == null)
	        return;

	    // Update A and B
	    Node A = targetNode.prev;
	    Node B = targetNode.next;

	    // A could be null if target is head
	    if (A != null) {
	        A.next = B;
	    }
	    // B could be null if target is tail
	    if (B != null) {
	        B.prev = A;
	    }

	    if (targetNode == head) {
	        head = targetNode.next;
	    }
	}
	
	//to print linked list elements
	public void print(){
        Node temp = this.head;
        while(temp!=null){
            System.out.printf("%d ",temp.value);
            temp=temp.next;
        }
        System.out.print("\n");
    }
		
	
	public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
        	System.out.println("No. of elements to insert");
			int n = sc.nextInt();
			DoublyLinkedList list = new DoublyLinkedList();
			for (int i = 0; i < n; i++) {
			    int value = sc.nextInt();
			    list.insertAtIndex(i, value);
			}
	        list.print();
	        System.out.println("enter value to delete");
	        int val = sc.nextInt();
	        list.deleteNode(val);
	        list.print();
		}
        
    }
}
