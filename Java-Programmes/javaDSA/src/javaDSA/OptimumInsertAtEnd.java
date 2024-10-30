package javaDSA;

import javaDSA.LinkedListCode.Node;

/**The way we are doing insertion at the end is not really optimal. Every time we want to add an item at the end, we iterate through the complete list to reach the end.
 * The time complexity of insertion at end is thus O(N) where N is the size of the linked list. But we can make it O(1).
 * By maintaining a tail pointer, which will point to the last element of the linked list. Thus whenever we want to insert at the end, we can use tail for that.
 * 
 */
public class OptimumInsertAtEnd {

	static class LinkedList {
	    public Node head;

	    // Create the Node tail
	    public Node tail;

	    public void insertAtEnd(int value) {
	        Node newNode = new Node(value);

	        // If there are no nodes in the linked list
	        // Set the new node as head and tail
	        if (head == null) {
	            head = newNode;
	            tail = newNode;
	            return;
	        }

	        // Set next of tail to the new Node
	        tail.next = newNode;

	        // Set new Node as the new tail
	        tail = newNode;
	    }

	    public void print() {
	        Node current = head;
	        while (current != null) {
	            System.out.print(current.data + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		for(int i=1 ; i<=3 ; i++){
            int value = i*10;
            list.insertAtEnd(value);
        }
		
		System.out.println("Printing Linked List: ");
        list.print();

	}

}
