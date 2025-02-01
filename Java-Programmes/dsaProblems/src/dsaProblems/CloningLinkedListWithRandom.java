/*
 * Problem: 
 * Clone a linked list with next and random pointer

	You are given a special linked list where each node has a next pointer pointing to its next node. You are also given some random pointers, where you will be given some pairs denoting two nodes a and b i.e. a->random = b (random is a pointer to a random node).
	
	Construct a copy of the given list. The copy should consist of the same number of new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the original and copied list pointers represent the same list state. None of the pointers in the new list should point to nodes in the original list.
	
	For example, if there are two nodes x and y in the original list, where x->random = y, then for the corresponding two nodes xnew and ynew in the copied list, xnew->random = ynew.
	
	Return the head of the copied linked list.
	
	NOTE : 
	1. If there is any node whose arbitrary pointer is not given then it's by default NULL. 
	2. Don't make any changes to the original linked list.
	
	ArbitLinked List1
	
	Note: The diagram isn't part of any example, it just depicts an example of how the linked list may look.
	
	Examples:
	
	Input: LinkedList: 1->2->3->4 , pairs = [{1,2},{2,4}]
	Output: true
	Explanation: In this test case, there are 4 nodes in linked list.  Among these 4 nodes,  2 nodes have arbitrary pointer set, rest two nodes have arbitrary pointer as NULL. Second line tells us the value of four nodes. The third line gives the information about arbitrary pointers. The first node arbitrary pointer is set to node 2.  The second node arbitrary pointer is set to node 4.
	Input: LinkedList: 1->3->5->9 , pairs[] = [{1,1},{3,4}]
	Output: true
	Explanation: In the given testcase, applying the method as stated in the above example, the output will be 1.

 */

package dsaProblems;

import java.util.*;

class Node {
  int data;
  Node next, random;

  Node(int d) {
      data = d;
      next = random = null;
  }
}

public class CloningLinkedListWithRandom {

    public static Node addToTheLast(Node head, Node node) {
        if (head == null) {
            return node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
            return head;
        }
    }

    public static boolean validation(Node head, Node res) {
        Node temp1 = head;
        Node temp2 = res;

        int len1 = 0, len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        if (len1 != len2) return false;

        HashMap<Node, Node> nodeMap = new HashMap<>();

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            if (temp1 == temp2) return false;
            if (temp1.data != temp2.data) return false;

            if ((temp1.random == null && temp2.random != null) ||
                (temp1.random != null && temp2.random == null)) {
                return false;
            }
            if (temp1.random != null && temp2.random != null &&
                temp1.random.data != temp2.random.data) {
                return false;
            }
            nodeMap.put(temp1, temp2);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            if (temp1.random != null && nodeMap.get(temp1.random) != temp2.random) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    // Function to clone a linked list with next and random pointer.
    static Node copyList(Node head) {
        // your code here
        Node oldHead = head;
        Node newHead = null;
        
        while(oldHead!=null) {
            newHead = addToTheLast(newHead, new Node(oldHead.data));
            oldHead = oldHead.next;
        }
        
        oldHead = head;
        Node newHead2 = newHead;
        
        while(oldHead!= null) {
            if(oldHead.random == null) {
                newHead2.random = null;
            }
            else {
                Node temp1 = head;
                Node temp2 = newHead;
                while(temp1 != null && temp1 != oldHead.random) {
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
                newHead2.random = temp2;
            }
            oldHead = oldHead.next;
            newHead2 = newHead2.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline after the integer input

        while (t-- > 0) {
            Node head = null, head2 = null;
            String line = sc.nextLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = Arrays.stream(numsStr).mapToInt(Integer::parseInt).toArray();

            int n = nums.length;
            head = addToTheLast(head, new Node(nums[0]));
            head2 = addToTheLast(head2, new Node(nums[0]));

            for (int i = 1; i < n; i++) {
                head = addToTheLast(head, new Node(nums[i]));
                head2 = addToTheLast(head2, new Node(nums[i]));
            }

            String line2 = sc.nextLine().trim();
            String[] numsStr2 = line2.split(" ");
            int[] nums2 = Arrays.stream(numsStr2).mapToInt(Integer::parseInt).toArray();
            int q = nums2.length / 2;

            for (int i = 0; i < q; i++) {
                int a = nums2[2 * i];
                int b = nums2[2 * i + 1];

                Node tempA = head;
                Node temp2A = head2;
                for (int j = 0; j < a - 1 && tempA != null; j++) {
                    tempA = tempA.next;
                    temp2A = temp2A.next;
                }
                Node tempB = head;
                Node temp2B = head2;
                for (int j = 0; j < b - 1 && tempB != null; j++) {
                    tempB = tempB.next;
                    temp2B = temp2B.next;
                }

                if (a <= n) {
                    tempA.random = tempB;
                    temp2A.random = temp2B;
                }
            }

            Node res = copyList(head);

            if (validation(head, res) && validation(head2, res))
                System.out.println("true");
            else
                System.out.println("false");
        }
        sc.close();
    }
}

class Solution {
  
}
