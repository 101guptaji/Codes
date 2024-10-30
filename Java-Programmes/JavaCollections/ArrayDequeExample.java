//Java program to demonstrate the operation on ArrayDeque

import java.util.*;
public class ArrayDequeExample {
 public static void main(String[] args)
 {
     // Initializing an deque
     Deque<String> dq  = new ArrayDeque<String>();

     // add() method to insert
     dq.add("Mango");
     dq.addFirst("Apple");
     dq.addLast("Grapes");

     System.out.println(dq);

     System.out.println(dq.pop());

     System.out.println(dq.poll());

     System.out.println(dq.pollFirst());

     System.out.println(dq.pollLast()); //no error even deque is empty whereas pop() gives error
     
     // offer() and push() method to insert
     dq.offer("Tail1");
     dq.offerFirst("Head1");
     dq.offerLast("tail2");
     dq.push("head2");

     for (Iterator itr = dq.iterator();
         itr.hasNext();) {
         System.out.print(itr.next() + " ");
     }

     System.out.println();

     for (Iterator itr = dq.descendingIterator();
         itr.hasNext();) {
         System.out.print(itr.next() + " ");
     }
     
     
 }
}
