/*
 * Detect Loop or Cycle in Linked List

    Given a singly linked list, check if the linked list has a loop (cycle) or not. A loop means that the last node of the linked list is connected back to a node in the same list.

    Examples:

    Input: head: 1 -> 3 -> 4 -> 3
    Output: true


 */
package dsaProblems;

import java.util.HashSet;

class Node {
    int data;
    Node next;

    public Node(int x) {
        this.data = x;
        this.next = null;
    }
}

public class CycleInLinkedList {
    // Method-1 using HashSet
    // TC: O(n), SC: O(n)
    // static boolean detectLoop(Node head) {
    //     HashSet<Node> st = new HashSet<>();

    //     while (head != null) {
    //         // If we are seeing the node for
    //         // the first time, insert it in hash
    //         st.add(head);

    //         // If next node is already present
    //         // in hashmap it means there is a cycle
    //         if (st.contains(head.next)){
    //             System.out.println(head.next.data);
    //             return true;
    //         }

    //         head = head.next;
    //     }
    //     return false;
    // }

    // Method-2 Using Floyd's Cycle-Finding Algorithm - O(n) Time and O(1) Space
    static boolean detectLoop(Node head) {
        // Fast and slow pointers initially points to the head
        Node slow = head, fast = head;

        // Loop that runs while fast and slow pointer are not
        // null and not equal
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If fast and slow pointer points to the same node,
            // then the cycle is detected
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 3 -> 4 -> 3
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);

        // Create a loop
        head.next.next.next = head.next;

        if (detectLoop(head))
            System.out.println("true");
        else
            System.out.println("false");
    }
}