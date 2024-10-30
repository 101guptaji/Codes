/*
 * Given a Circular Linked List. The task is to delete the given node, key in the circular linked list, and reverse the circular linked list.
 * Input: Linked List: 2->5->7->8->10, key = 8
	Output: 10->7->5->2 
	Explanation: After deleting 8 from the given circular linked list, it has elements as 2, 5, 7, 10. 
		Now, reversing this list will result in 10, 7, 5, 2 & the resultant list is also circular.
 */
package dsaProblems;

import java.io.*;
import java.util.*;

/*class Node {
	  int data;
	  Node next;
	
	  Node(int x) {
	      data = x;
	      next = null;
	  }
}*/

class DeleteReverseCircularLinkedList {
	  // Function to reverse a circular linked list
	  static Node reverse(Node head) {
	      // code here
	      if(head == null || head.next == head)
	          return head;
	          
	      Node prev = null, next = null;
	      Node curr = head;
	      while(true){
	          next = curr.next;
	          curr.next = prev;
	          prev = curr;
	          curr = next;
	          
	          if(curr == head)
	              break;
	      }
	      head.next = prev;
	      head = prev;
	      return head;
	  }

	  // Function to delete a node from the circular linked list
	  static Node deleteNode(Node head, int key) {
	      // code here
	       if(head == null || (head.next == head && head.data == key))
	          return null;
	      Node temp = head;
	      if(head.data == key){
	          while(temp.next != head){
	              temp = temp.next;
	          }
	          temp.next = head.next;
	          //printList(temp.next);
	          return temp.next;
	      }

	      while(temp.next != head){
	          if(temp.next.data == key){
	              temp.next = temp.next.next;
	              return head;
	          }
	          temp = temp.next;
	      }
	      //printList(head);
	      return head;
	  }
	  
	  // Function to print nodes in a given circular linked list
	  static void printList(Node head) {
	      if (head == null) {
	          System.out.println("empty");
	          return;
	      }
	      Node temp = head;
	      do {
	          System.out.print(temp.data + " ");
	          temp = temp.next;
	      } while (temp != head);
	      System.out.println();
	  }
	
	  public static void main(String[] args) throws IOException {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int t = Integer.parseInt(br.readLine());
	
	      while (t-- > 0) {
	          List<Integer> arr = new ArrayList<>();
	          String input = br.readLine();
	          StringTokenizer st = new StringTokenizer(input);
	          while (st.hasMoreTokens()) {
	              arr.add(Integer.parseInt(st.nextToken()));
	          }
	          int key = Integer.parseInt(br.readLine());
	          Node head = new Node(arr.get(0));
	          Node tail = head;
	          for (int i = 1; i < arr.size(); ++i) {
	              tail.next = new Node(arr.get(i));
	              tail = tail.next;
	          }
	          tail.next = head; // Make the list circular

	          Node current = deleteNode(head, key);
	          Node rev = reverse(current);
	          printList(rev);
	      }
	  }
}



