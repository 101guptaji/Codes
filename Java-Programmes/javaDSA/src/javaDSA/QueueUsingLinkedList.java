package javaDSA;

import java.util.Scanner; 

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        next = null;
    }
}  

public class QueueUsingLinkedList {
    static class Queue{
        Node front = null;
        Node rear = null;

        boolean isEmpty(){
            if(front == null && rear == null){
                return true;
            }
            return  false;
        }

        void enqueue(int ele){
            if(front == null && rear == null){
                front = new Node(ele);
                rear = front;
            }
            else{
                rear.next = new Node(ele);
                rear = rear.next;
            }

        }

        int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }

            int ele = front.data;
            if(front == rear){
                front = null;
                rear = null;
            }
            else
               front = front.next;

            return ele;
        }

        int peek(){
            if(isEmpty()){
                System.err.println("Queue is empty");
                return -1;
            }
            return front.data;
        }

        void print(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return;
            }
            System.out.println("Printing Queue");
            Node tmp = front;
            while(tmp != null){
                System.out.println(tmp.data);
                tmp = tmp.next;
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
