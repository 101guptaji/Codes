/*
 * Given two sorted linked lists consisting of n and m nodes respectively. 
 * The task is to merge both of the lists and return the head of the merged list.
 * 
 * Examples:
    Input: head1 = 5 -> 10 -> 15 -> 40, head2 = 2 -> 3 -> 20
    Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40
 */
package dsaProblems;

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class MergeSortedLinkedList {
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
        System.out.println("~");
    }

    // Insert node into the list in a sorted manner
    public static Node insertSorted(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null || head.data >= data) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;
        while (current.next != null && current.next.data < data) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    // Function to merge two sorted linked list.
    static Node sortedMerge(Node head1, Node head2) {
        // Base cases
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        Node head;
        if (head1.data < head2.data) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }

        Node curr = head;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } 
            else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if (head1 == null) {
            curr.next = head2;
        } 
        else {
            curr.next = head1;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head1 = null;
        Node head2 = null;

        // Reading first linked list input
        String input1 = sc.nextLine();
        String[] elems1 = input1.split(" ");
        for (String elem : elems1) {
            head1 = insertSorted(head1, Integer.parseInt(elem));
        }

        // Reading second linked list input
        String input2 = sc.nextLine();
        String[] elems2 = input2.split(" ");
        for (String elem : elems2) {
            head2 = insertSorted(head2, Integer.parseInt(elem));
        }

        // Merging sorted linked lists
        Node mergedHead = sortedMerge(head1, head2);
        printList(mergedHead); // Print the merged sorted list

        sc.close();
    }
}

