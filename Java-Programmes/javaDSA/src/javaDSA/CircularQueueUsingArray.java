package javaDSA;

import java.util.Scanner;

public class CircularQueueUsingArray {
    static class Queue{
        int[] arr;
        int size;
        int front = -1, rear = -1;

        Queue(int n){
            arr = new int[n];
            size = n;
        }

        boolean isEmpty(){
            if(front == -1 && rear == -1){
                return true;
            }
            return  false;
        }

        void enqueue(int ele){
            //check for full
            if((rear+1)%size == front){
                System.out.println("Queue is full");
                return;
            }
            if(front == -1 && rear == -1){
                front = 0;
                rear = 0;
            }
            else{
                rear = (rear+1)%size;
            }

            arr[rear] = ele;
        }

        int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int ele = arr[front];
            if(front == rear){
                front =-1;
                rear = -1;
            }
            else
               front = (front+1)%size;
            return ele;
        }

        int peek(){
            if(isEmpty()){
                System.err.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }

        void print(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return;
            }
            System.out.println("Printing Queue");
            int i=front;
            while(i != rear){
                System.out.println(arr[i]);
                i = (i+1)%size;
            }
            System.out.println(arr[rear]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of Queue");
        int n = sc.nextInt();
        Queue queue = new Queue(n);
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
