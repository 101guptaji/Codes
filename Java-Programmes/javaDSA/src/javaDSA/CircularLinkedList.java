package javaDSA;

import java.util.Scanner;

/*
 * In a Circular Linked-list, The first node and the last node are connected to each other which forms a circle. 
 * There is no null at the end.
 * Some important points regarding circular linked-list:
 	Starting from any node, you can traverse the whole list.
 	An additional tail pointer is maintained which helps us in operations to be performed at the last element easily.
 	Very useful in programs where we need to repetitively iterate the list.
  	The structure of each node is still same as singly linked list, i.e, value and next pointer.
 * 
 */
public class CircularLinkedList {
	public class Node{
		int value;
		Node next;
		
		public Node(int val)
		{
			value = val;
			next = null;
		}
	}
	
	Node head, tail;
	
	public CircularLinkedList() {
		head = null;
		tail = null;
	}
	
	//insert an element at end
	public void insertAtEnd(int val){

        Node newnode = new Node(val);

        if(this.head==null){
            // When the list is empty
            // Note that even though there is not really a head in the list (you can traverse the list starting at any point), we maintain the first node we insert as the head
            this.head = newnode;
            this.tail = newnode;
        }
        else{
            // When the list is not empty
            // Adding a new element towards the end of list
            this.tail.next = newnode;
            // Updating the tail pointer so that it points to the last element
            this.tail = newnode;
        }
        // The last element always points to the head
        this.tail.next=head;
    }

	//delete the node having that value
	void deleteNode(int value) {
	    // If there is only one element and it is the value to be deleted, remove it    
	    if (head == tail && head.value == value) {
	        head = null;
	        tail = null;
	        return;
	    }
	
	    // if the target is at head set head to second element and set tail's next to the new head
	    if (head.value == value) {
	        head = head.next;
	        tail.next = head;
	        return;
	    }
	    
	    // Now iterate over the linked list till you reach the tail and check if the next node is target
	    Node iter = head;
	    while (iter.next != null && iter != tail) {
	        if (iter.next.value == value) {
	            // If we found the value
	            // Set current node's next to the next of the next node and return
	            iter.next = iter.next.next;
	            break;
	        }
	        iter = iter.next;
	    }
	}

    public void print(){
        Node temp = this.head;
        while(temp!=null){
            System.out.printf("%d ",temp.value);
            if(temp==this.tail) 
            	break;
            temp=temp.next;
        }
        System.out.print("\n");
    }
	
	public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
        	System.out.println("No. of elements to insert");
			int n = sc.nextInt();
			CircularLinkedList list = new CircularLinkedList();
			for (int i = 1; i <= n; i++) {
			    //int value = sc.nextInt();
			    list.insertAtEnd(10*i);
			}
			list.print();
			System.out.println("enter value to delete");
	        int val = sc.nextInt();
	        list.deleteNode(val);
	        list.print();
		}
        
        
    }
}
