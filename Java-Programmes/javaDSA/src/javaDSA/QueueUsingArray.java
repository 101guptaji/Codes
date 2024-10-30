/*
 * A queue is a linear data structure that stores elements in a sequence and follows a First-In-First-Out (FIFO) order: 
    Structure: A queue has two ends, the front and the rear, where data is added and removed, respectively. 
    Operations: The basic operations on a queue are enqueue, dequeue, peek, isEmpty, and size: 
        Enqueue: Adds an element to the rear of the queue 
        Dequeue: Removes and returns the first element from the front of the queue 
        Peek: Returns the first element in the queue 
        isEmpty: Checks if the queue is empty 
        Size: Finds the number of elements in the queue 

 */
package javaDSA;
import java.util.Scanner;

public class QueueUsingArray {
    static class Queue{
        int[] arr;

        Queue(int n){
            arr = new int[n];
        }

        int front = -1, rear = -1;

        boolean isEmpty(){
            if(front == -1 || front > rear){
                return true;
            }
            return false;
        }

        void enqueue(int ele){
            if(rear+1 == arr.length){
                System.out.println("Queque is full");
                return;
            }
            if(front == -1 && rear == -1){
                front = 0;
                rear = 0;
            }
            else{
                rear++;
            }
            arr[rear] = ele;
        }

        int dequeue(){
            if(isEmpty()){
                System.err.println("Queue is empty");
                return -1;
            }
            int ele = arr[front];
            if(front == rear){
                front =-1;
                rear = -1;
            }
            else
                front++;
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
            for(int i=front;i<=rear;i++){
                System.out.println(arr[i]);
            }
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
