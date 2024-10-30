package javaDSA;

/*
 * Linked list is a linear data structure where each element is a separate object connected to each other and is similar to Arrays.
 * Head pointer of the linked list points to first node and each node contains two fields:
	Value (Integer)
	Pointer to next node
 * The last node of a linked list is called Tail. The Tail's next pointer is NULL address indicating there is no element after it.
 * Linked List - Operations
	1. Insertion: Inserting an element at end/beginning or in the middle at some k-th position.
 	2. Deletion: Deleting an element from the list.
 	3. Display: Traversing the whole linked list and output each element.
 * 
 */
public class LinkedListCode {
	public Node head;
	
	public LinkedListCode()
	{
		head = null;
	}
	
	static class Node{
		public int data;
		public Node next;
		
		public Node(int val)
		{
			data = val;
			next = null;
		}
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
	
	/*Delete from front: 
	* Before deleting a node, we will need to find it by value. To find a value, we can traverse the linked list and see if node of any value matches the value we want to delete.
	* Once the targetNode is found, we can then delete it.
	*/
	void deleteFront(int value) {
	    if (head.data == value) {
	        Node targetNode = head;
	        // Set head to the next of the current node
	        head = targetNode.next;
	    }
	}
	
	//Delete any element
	void deleteNode(int value) {
	    if (head.data == value) {
	        Node targetNode = head;
	        head = targetNode.next;
	        return;
	    }
	    Node curr = head;
	    // Traverse the list
	    // When next element is our target element, eliminate it
	    while (curr.next != null) {
	        if (curr.next.data == value) {
	            // Set next of current
	            Node target = curr.next; 
	            // To next to next of current
	            curr.next = target.next;
	            
	            return;
	        }
	        curr = curr.next;
	    }
	}
	
	//to get value at head 
	public int getHeadValue()
	{
		if(head == null)
			return -1;
		else
			return head.data;
	}
	
	//to print linked list elements
	public void print(){
        Node temp = this.head;
        while(temp!=null){
            System.out.printf("%d ",temp.data);
            temp=temp.next;
        }
        System.out.print("\n");
    }
	
	
	public static void main(String[] args)
	{
		System.out.println("Creating LinkedList");
		Node head = new Node(3);
		System.out.println("Value at Head: "+head.data);
		
		System.out.println("Creating LinkedList");
		LinkedListCode list = new LinkedListCode();
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
        
        list.deleteFront(1);
        System.out.println("Linked List after deleting front: ");
        list.print();
        
        list.deleteNode(10);
        System.out.println("Linked List after deleting 7: ");
        list.print();
	}
}
