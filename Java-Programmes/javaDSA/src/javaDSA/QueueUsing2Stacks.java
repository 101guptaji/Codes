package javaDSA;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsing2Stacks {
    static class Queue{
        Stack<Integer> s1 = new Stack<>(); //main stack to store element in reverse order
        Stack<Integer> s2 = new Stack<>(); //helper stack

        boolean isEmpty(){
            return  s1.isEmpty();
        }

        void enqueue(int ele){
            //transfer all elements of stack1 to stack2
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            //add ellement to stack1 when it is empty
            s1.push(ele);

            ////transfer back all elements of stack1 from stack2
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }

            return s1.pop();
        }

        int peek(){
            if(isEmpty()){
                System.err.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }

        void print(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return;
            }
            System.out.println("Printing Queue");
            
            while(s1.isEmpty()){
                System.out.println(s1.pop());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue queue = new Queue();
        int choice=5;   
        while(choice != 0)   
        {     
            System.out.println("\n*************************Main Menu*****************************");  
            System.out.println("=================================================================");  
            System.out.println("1.insert an element \n2.Show front element \n3.Delete an element\n4.Display the queue\n0.Exit");  
            System.out.println("\nEnter your choice ?");  
            choice = sc.nextInt();  
            switch(choice)  
            {  
                case 1:  
                    System.out.println("Enter the element");
                    int ele = sc.nextInt();
                    queue.enqueue(ele);
                    break;  
                case 2:  
                    int item = queue.peek();
                    if(item != -1){
                        System.out.println("Peeked: "+item);
                    }
                    break;  
                case 3:  
                    item = queue.dequeue();
                    if(item != -1){
                        System.out.println("Popped: "+item);
                    }
                    break;   
                case 4:  
                    queue.print(); 
                    break;  
                default:   
                    System.out.println("\nEnter valid choice??\n");  
            }  
        }  
        sc.close();
    }
}
