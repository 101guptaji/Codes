/*
 * Given a singly linked list and an integer, x. Delete the xth node (1-based indexing) from the singly linked list.
 */
package javaDSA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
  int data;
  Node next;

  Node(int d) {
      data = d;
      next = null;
  }
}

class DeleteNodeLinkedList {
  Node head;

  void printList(Node head) {
      Node temp = head;
      while (temp != null) {
          System.out.print(temp.data + " ");
          temp = temp.next;
      }
      System.out.println();
  }

  public Node deleteNode(Node head, int x) {
      // code here
      if(head == null){
          return head;
      }
      if(x==1){
          return head.next;
      }
      
      Node temp = head;
      while(--x > 1 && temp.next!=null){
          temp = temp.next;
      }
      if(temp.next!=null){
          temp.next = temp.next.next;
      }
      return head;
  }
  
  public static void main(String args[]) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(in.readLine());
      while (t > 0) {
          String[] s = in.readLine().trim().split(" ");
          Node head = new Node(Integer.parseInt(s[0]));
          Node copy = head;
          for (int i = 1; i < s.length; i++) {
              copy.next = new Node(Integer.parseInt(s[i]));
              copy = copy.next;
          }

          int x = Integer.parseInt(in.readLine());
          
          DeleteNodeLinkedList del = new DeleteNodeLinkedList();
          Node ans = del.deleteNode(head, x);

          while (ans != null) {
              System.out.print(ans.data + " ");
              ans = ans.next;
          }
          System.out.println();

          t--;
      }
  }
}
