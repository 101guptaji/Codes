/*
 * Given two sorted linked lists consisting of nodes respectively. The task is to merge both lists and return the head of the merged list.
 */
package dsaProblems;

import java.util.*;

public class MergeTwoSortedLinkedLists {
	
	  public static void printList(Node head) {
	      Node temp = head;
	      while (temp != null) {
	          System.out.print(temp.data + " ");
	          temp = temp.next;
	      }
	      System.out.println();
	  }
  
	 //Function to merge two sorted linked list.
	 static Node sortedMerge(Node head1, Node head2) {
	     // This is a "method-only" submission.
	     // You only need to complete this method
	     Node head;
	     if(head1.data<head2.data){
	         head = head1;
	         head1 = head1.next;
	     }
	     else{
	         head = head2;
	         head2 = head2.next;
	     }
	     Node temp = head;
	     
	     while(head1 != null && head2 != null){
	         if(head1.data<head2.data){
	             temp.next = head1;
	             head1 = head1.next;
	         }
	         else{
	             temp.next = head2;
	             head2 = head2.next;
	         }
	         temp = temp.next;
	     }
	     
	     if(head1 == null){
	         temp.next = head2;
	     }
	     else{
	         temp.next = head1;
	     }
	
	     return head;
	 }

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      sc.nextLine();
      while (T-- > 0) {
          Node head1 = null, tail1 = null;
          Node head2 = null, tail2 = null;

          String input1 = sc.nextLine();
          String[] elems1 = input1.split(" ");
          for (String elem : elems1) {
              Node newNode = new Node(Integer.parseInt(elem));
              if (head1 == null) {
                  head1 = newNode;
                  tail1 = newNode;
              } else {
                  tail1.next = newNode;
                  tail1 = newNode;
              }
          }

          String input2 = sc.nextLine();
          String[] elems2 = input2.split(" ");
          for (String elem : elems2) {
              Node newNode = new Node(Integer.parseInt(elem));
              if (head2 == null) {
                  head2 = newNode;
                  tail2 = newNode;
              } else {
                  tail2.next = newNode;
                  tail2 = newNode;
              }
          }

          Node head = sortedMerge(head1, head2);
          printList(head);
      }
      sc.close();
  }
}











