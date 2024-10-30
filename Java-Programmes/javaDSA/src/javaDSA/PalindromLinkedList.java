/*
 * Check if a Linked List is a palindrome
	Time complexity - O(n)
	Space complexity - O(1)  
 */
package javaDSA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javaDSA.ReverseLinkedList.Node;

public class PalindromLinkedList {
	
	static Node getMiddle(Node head) {
		Node slow = head, fast = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	static Node reverseList(Node head) {
		Node next=null, curr=head, prev=null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
				
		return prev;
	}
	
	static boolean IsPalindrom(Node head) {
		if(head == null || head.next == null) {
			return true;
		}
		
		Node middleNode = getMiddle(head);
		Node lastNode = reverseList(middleNode);
		Node firstNode = head;
		while(firstNode != null && lastNode != null) {
			if(firstNode.data != lastNode.data) {
				return false;
			}
			firstNode = firstNode.next;
			lastNode = lastNode.next;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] list = br.readLine().split(" ");
		
		Node head = new Node(Integer.parseInt(list[0]));
		Node tail = head;
		for(int i=1;i<list.length;i++) {
			tail.next = new Node(Integer.parseInt(list[i]));
			tail = tail.next;
		}

		System.out.println(IsPalindrom(head));
	}
}
