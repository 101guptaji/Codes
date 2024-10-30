package javaDSA;

/*
 * StackUsingArray Introduction
A stack data structure is a collection that follows a specific order in which operations are performed. 
The order is Last In, First Out (LIFO). This means that the last element added to the stack will be the first one to be removed.

To visualize a stack, consider a pile of books placed one on top of the other. Here's how the stack data structure would work in this analogy:

Adding a book (Push operation): When you add a new book to the stack, you place it on top of the existing pile. 
This is similar to the "push" operation in a stack data structure. You can only add (push) a new book at the top of the pile, not in the middle or at the bottom.

Removing a book (Pop operation): When you want to remove a book from the stack, you always take it from the top. 
This is like the "pop" operation. You can't remove a book from the middle or the bottom without first removing all the books on top of it. 
Popping a book off the stack reveals the book that was previously underneath it, which you can then read or pop off next.

Peeking at the top book (Peek operation): If you want to check which book is currently at the top of the stack without removing it, you can take a quick look. 
In stack terminology, this is called a "peek" operation, where you're inspecting the element at the top of the stack without modifying the stack itself.

Checking if the stack is empty: If you've removed all the books from the pile and there are none left, your stack of books is now empty. 
In the stack data structure, you can perform an operation to check whether the stack is empty before attempting to pop, which would be an error since there's nothing to remove.

Size of the stack: The number of books in the pile at any given time corresponds with the size of the stack. As you add (push) and remove (pop) books, the size of your stack changes.

In the stack of books analogy, it's clear that you have access only to the topmost book and don't have direct access to the books lower down in the pile. 
Similarly, in a stack data structure, you generally only have access to the top element, reflecting the LIFO principle. 
This makes the stack an ideal structure for certain applications, such as undo mechanisms in software, function call stacks in programming languages, and parsing expressions in compilers.
 * 
 */
public class StackUsingArray {
	static final int MAX_SIZE = 101;
	static int[] arr = new int[MAX_SIZE];
	static int top =-1;
	
	static void push(int ele)
	{
		if(top < MAX_SIZE)
		{
			top++;
			arr[top] = ele;
			System.out.println("Pushed: " + ele);
        } 
        else {
            System.out.println("Stack is full. Cannot push: " + ele);
        }
	}
	
	static int pop()
	{
		if(top >= 0) {
			int ele = arr[top];
			top--;
			System.out.println("Popped: " + ele);
            return ele;
        } 
        else {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
	}
	
	static int peek() {
	    if (top >= 0) {
	        int ele = arr[top];
	        System.out.println("Peeked: " + ele);
	        return ele;
	    } else {
	        System.out.println("Stack is empty. Cannot peek.");
	        return -1;
	    }
	}

	static boolean is_empty() {
	    return top == -1;
	}

	static boolean is_full() {
	    return top >= MAX_SIZE;
	}

	
	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		StackUsingArray s = new StackUsingArray();
		StackUsingArray.push(4);
		StackUsingArray.push(11);
		StackUsingArray.pop();
		s.push(14);
		s.pop();
		s.push(32);
		if(!StackUsingArray.is_empty()) {
			StackUsingArray.peek();
		}
		if(!StackUsingArray.is_full()) {
			s.push(15);
			StackUsingArray.peek();
		}
	}
}

/*
 * Uses of StackUsingArray
 * Expression Evaluation: Stacks are widely used in evaluating expressions, particularly mathematical expressions.
	For example, they can be used to convert infix expressions (e.g., 3 + 4 * 2) to postfix (or reverse Polish notation) expressions for easy evaluation.
 * Function Calls and Recursion.
 * Undo/Redo Functionality.
 * Backtracking Algorithms.
 * Parsing and Syntax Analysis: .
 * Browser History.
 * Task Management.
 * Memory Allocation and Deallocation.
*/
