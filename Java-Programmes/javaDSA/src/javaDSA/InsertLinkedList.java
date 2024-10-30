package javaDSA;
/*
 * Linked List - Operations
 * The primary operations which we do on a linked list are:
	1. Insertion: Inserting an element at end/beginning or in the middle at some k-th position.
 	2. Deletion: Deleting an element from the list.
 	3. Display: Traversing the whole linked list and output each element.
 * 
 * 
 */

public class InsertLinkedList {
	
	static class Node{
		public int value;
		public Node next;
		
		public Node(int val)
		{
			value = val;
			next = null;
		}
	}
	
	static class LinkedList{
		public Node head;
		
		public LinkedList()
		{
			head = null;
		}
		
		//Insert value at front(head)
		public void insertFront(int value) {
			//System.out.println("Inserting "+value);
			// Step 1: Create a new Node
	        Node newNode = new Node(value);
	        
	        // Step 2: Set next of newNode to the current head
	        newNode.next = head;
	        
	        // Step 3: Set newNode as the head
	        head = newNode;
		}
		
		//Insert value at end(tail)
		public void insertAtEnd(int val){
            Node newNode = new Node(val);
            //System.out.println("Inserting "+val);
            if(this.head==null){
                // The list is empty, thus we just need to assign head to the only element
                head = newNode;
            }
            else{
                // Iterating towards the end of the list
                Node temp = this.head;
                while(temp.next!=null){
                    //System.out.printf("%d ",temp.value);
                    temp=temp.next;
                }
                // Updating the next pointer of the this element
                temp.next = newNode;
            }
        }
		
		//Insert element at k-th position
		void insertAfterK(int value, int k) {
		    Node newNode = new Node(value);
		    Node current = head;

		    // If there are no nodes in the linked list
		    // Set the new node as head and return
		    if (current == null) {
		        head = newNode;
		        return;
		    }

		    // Iterate to the k-th node
		    for (int i = 1; i < k; i++) {
		        current = current.next;
		    }

		    // Set the next of new Node to next of current
		    newNode.next = current.next;

		    // Set the next of current to new Node
		    current.next = newNode;
		}
		
		//to get value at head 
		public int getHeadValue()
		{
			if(head == null)
				return -1;
			else
				return head.value;
		}
		
		public void print(){
            Node temp = this.head;
            while(temp!=null){
                System.out.printf("%d ",temp.value);
                temp=temp.next;
            }
            System.out.print("\n");
        }
	}
	
	public static void main(String[] args)
	{
		System.out.println("Creating LinkedList");
		LinkedList list = new LinkedList();
		list.insertFront(3);
		System.out.println("Value at Head: "+list.getHeadValue());
		
		list.insertFront(2);
		System.out.println("Value at Head: "+list.getHeadValue());
		
		list.insertFront(1);
		System.out.println("Value at Head: "+list.getHeadValue());
		
		for(int i=1 ; i<=3 ; i++){
            int value = i*10;
            list.insertAtEnd(value);
        }
		
		list.insertAfterK(7, 2);
		System.out.println("Printing Linked List: ");
        list.print();
	}
}
