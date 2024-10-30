/*
 * You are given a Linked List. Sort the given Linked List using quicksort. 
    Examples:
    Input: Linked list: 1->6->2
    Output: 1->2->6
 */
package dsaProblems;

import java.io.*;

//class for node of Linked List
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class QuickSortLL {
    static Node head;

    //function to quick sort linked list
    public static Node quickSort(Node head) {
        // Your code here
        sort(head, null);
        
        return head;
    }
    
    // The main function that implements QuickSort
    // start --> Starting node,
    // end --> Ending node
    public static void sort(Node start, Node end){
        if(start == null || start == end){
            return;
        }

        // pi is partitioning Node
        Node pi = partition(start, end);
            
        // Separately sort elements before
        // partition and after partition
        sort(start, pi);
        sort(pi.next, end);
    }
    
    // This function takes first element as pivot, places the pivot element at its correct position
    // in sorted array, and places all smaller to left of pivot and all greater elements to right of pivot
    public static Node partition(Node start, Node end){
        Node pivot = start; //pivot as last element
        
        Node i = start; // Index of smaller element 
        for(Node j=start;j!=end;j=j.next){
            if(j.data < pivot.data){
                //swap
                i = i.next;
                swap(i,j);
            }
        }

        //place pivot at correct position
        swap(i,pivot);
        
        return i;
    }

    //function to swap data of 2 nodes
    public static void swap(Node a, Node b){
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        String str[] = read.readLine().trim().split(" ");
        int n = str.length;
        Node head = new Node(Integer.parseInt(str[0]));
        addToTheLast(head);

        for (int i = 1; i < n; i++) {
            int a = Integer.parseInt(str[i]);
            addToTheLast(new Node(a));
        }

        Node node = quickSort(head);

        printList(node);
        System.out.println();
        
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }
}













