package arrays;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArraylistInsertDelete {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> myList = new ArrayList<>();
        for(int i=0;i<n;i++){
            myList.add(sc.nextInt());
        }
        int q = sc.nextInt();
        //sc.nextLine();
  
        for(int i=0;i<q;i++){
        	String op = sc.next();
            if(op.equals("Insert")){
                int x = sc.nextInt();
                int y = sc.nextInt();
                myList.add(x, y);
                //myList = insert(myList, x, y);
            }
            if(op.equals("Delete")){
                int z = sc.nextInt();
                myList.remove(z);
                //delete(myList, z);
            }
        }
        for(int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));;
        }
    }
    
    static List<Integer> insert(List<Integer> list, int x, int y){
        List<Integer> newList = new ArrayList<Integer>();
        int i;
        for(i=0;i<x;i++){
            newList.add(list.get(i));
        }
        if(i == x)
            newList.add(y);
        for(i=x;i<list.size();i++){
            newList.add(list.get(i));
        }
        
        return newList;
    }
    
    static void delete(List<Integer> list, int z){
        list.remove(z);
    }
}