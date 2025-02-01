/*
 * Given two numbers represented as two lists, the task is to return the sum of two lists.

    Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

    Examples:

    Input: num1 = 4 -> 5, num2 = 3 -> 4 -> 5
    Output: 3 -> 9 -> 0 
    Explanation: Sum of 45 and 345 is 390.
    */
package dsaProblems;

import java.io.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class AddNumberLinkedLists {
    // function to trim leading zeros in linked list
    static Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }

    // Function to find the length of linked list
    static int listSize(Node head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    // Function to reverse the linked list
    public static Node reverseList(Node head) {
        Node prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static Node addTwoLists(Node num1, Node num2) {
        // code here
        num1 = removeLeadingZeros(num1);
        num2 = removeLeadingZeros(num2);

        // Find the length of both the linked lists
        int len1 = listSize(num1);
        int len2 = listSize(num2);

        // If num1 is smaller, swap the two linked lists by
        // calling the function with reversed parameters
        if (len1 < len2) {
            return addTwoLists(num2, num1);
        }

        num1 = reverseList(num1);
        num2 = reverseList(num2);

        Node head = num1;
        int carry = 0;

        // Iterate till either num2 is not empty or
        // carry is greater than 0
        while (num2 != null || carry != 0) {
            // Add carry to num1
            num1.data += carry;

            // If num2 linked list is not empty, add it to num1
            if (num2 != null) {
                num1.data += num2.data;
                num2 = num2.next;
            }

            // Store the carry for the next nodes
            carry = num1.data / 10;

            // Store the remainder in num1
            num1.data = num1.data % 10;

            // If we are at the last node of num1 but carry is
            // still left, then append a new node to num1
            if (num1.next == null && carry != 0) {
                num1.next = new Node(0);
            }

            num1 = num1.next;
        }

        // Reverse the resultant linked list to get the
        // required linked list
        return reverseList(head);
    }

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Node res = addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

/*
 * By storing sum on the longer list - O(m + n) Time and O(1) Space
 */